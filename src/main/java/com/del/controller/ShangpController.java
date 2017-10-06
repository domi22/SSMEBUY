package com.del.controller;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.del.pojo.Shangp;
import com.del.service.BuyCarService;
import com.del.service.DetailsService;
import com.del.service.ShangpService;

@Controller
@RequestMapping("/shangp")
public class ShangpController {

	@Resource(name="shangpService")
	private ShangpService shangpService;
	@Resource(name="buyCarService")
	private BuyCarService buyCarService;
	@Resource(name="detailsService")
	private DetailsService detailsService;
	
	Map<String,Object> pageMap = new HashMap<String,Object>();
	
	/*
	 * ��ҳ��ʾproduct-list����Ʒ
	 */
	@RequestMapping(value="/list",params={"goodid","currentPage"})
	public ModelAndView getShangpList(@RequestParam(value="goodid")int goodid,
			                          @RequestParam(value="currentPage")int currentPage){
		ModelAndView mandv = new ModelAndView();
		List<Shangp> productList = new ArrayList<Shangp>();
		//�ж��Ƿ����ർ���鿴product
		if(currentPage==-1){
			currentPage=1;
			pageMap.put("currentPage", 1);
			//��ѯ��ҳ��������ģ��
			int totalPage=0;
			int count  = shangpService.getShangpCount(goodid);
			totalPage = (count%3==0?count/3:(count/3+1));
			pageMap.put("totalPage", totalPage);
		}else{
			pageMap.put("currentPage", currentPage);
		}
		pageMap.put("goodid", goodid);
		pageMap.put("usecurrentPage", (currentPage-1)*3);
		//����goodid��ѯshangplist
		productList = shangpService.getProductShangp(pageMap);
		mandv.addObject("productList", productList);
		mandv.addObject("pageMap", pageMap);
		mandv.setViewName("shangp/product-list.jsp");
		return mandv;
	}
	
	
	/*
	 * ��ҳ��ʾ�������Ʒ
	 */
	@RequestMapping(value="/fatherlist",params={"fatherid","currentPage"})
	public ModelAndView doFatherList(@RequestParam(value="fatherid")int fatherid,
			                          @RequestParam(value="currentPage")int currentPage){
		ModelAndView mandv = new ModelAndView();
		List<Shangp> productList = new ArrayList<Shangp>();
		//�ж��Ƿ����ർ���鿴product
		if(currentPage==-1){
			currentPage=1;
			pageMap.put("currentPage", 1);
			//��ѯ��ҳ��������ģ��
			int totalPage=0;
			int count  = shangpService.findFatherCount(fatherid);
			totalPage = (count%3==0?count/3:(count/3+1));
			pageMap.put("totalPage", totalPage);
		}else{
			pageMap.put("currentPage", currentPage);
		}
		pageMap.put("fatherid", fatherid);
		pageMap.put("usecurrentPage", (currentPage-1)*3);
		//����goodid��ѯshangplist
		productList = shangpService.findFatherShangp(pageMap);
		mandv.addObject("productList", productList);
		mandv.addObject("pageMap", pageMap);
		mandv.setViewName("shangp/product-list.jsp");
		return mandv;
	}
	
	
	
	
	
	/*
	 * ��̨��Ʒ������ҳ��ʾȫ����Ʒ
	 */
	@RequestMapping(value="/page",params="usecurrentPage")
	public String doShangp(@RequestParam(value="usecurrentPage")int usecurrentPage,Model model){
		//��һ�ν����ҳ��ʾ
		if(usecurrentPage==-1){
		   usecurrentPage=1;
		}
		int newcurrentPage = (usecurrentPage-1)*3;
		int size = shangpService.findAllShangp();
		int totalPage = size%3==0?size/3:(size/3+1);
		model.addAttribute("usecurrentPage", usecurrentPage);
		
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("allshanglist", shangpService.findShangp(newcurrentPage));
		return "manager/product.jsp";
	}
	
	/*
	 * ��ѯ������Ʒ����
	 */
	@RequestMapping(value="/oneshang",params="shangid")
	public ModelAndView doOneShangp(@RequestParam(value="shangid")int shangid){
		ModelAndView mView = new ModelAndView();
		Shangp oneshang = shangpService.findOneShangp(shangid);
		mView.addObject("oneshang",oneshang);
		mView.setViewName("shangp/product-view.jsp");
		return mView;
	}
	
	/*
	 * ��̨�޸ĵ�����Ʒ����
	 */
	@RequestMapping(value="/toupd",params="shangid")
	public ModelAndView doUpdShangp(@RequestParam(value="shangid")int shangid){
		
		ModelAndView mView = new ModelAndView();
		Shangp updshang = shangpService.findOneShangp(shangid);
		mView.addObject("updshang",updshang);
		mView.setViewName("manager/product-modify.jsp");
		return mView;
	}
	
	
	
	
	/*
	 * 
	 * �޸���Ʒ��Ϣ
	 */
	@RequestMapping(value="/upd",method=RequestMethod.POST)
	public String doUpdShangp(Shangp shangp,HttpServletRequest request,
			                  @RequestParam(value="attachs",required=false)MultipartFile attachs,
			                  @RequestParam(value="shangid")String shangid){
		        
		        //Shangp shangp = new Shangp();
		        //���������ϴ��ļ���·��
				String spicpath = null;
				String errorinfo = "uploadspError";
				//�����ϴ����̹�����
				boolean flag = true;
				//�����ļ������λ��
				String path = request.getSession().getServletContext().getRealPath("statics"+File.separator+"uploadfiles");
				
					//�ж��ļ��Ƿ�Ϊ��
					if(!attachs.isEmpty()){
						
					//��ȡԴ�ļ���
					String oldName= attachs.getOriginalFilename();
					//��ȡԴ�ļ�����׺
					String prefixName = FilenameUtils.getExtension(oldName);
					
					int fileSize = 500000;
					//�ж��ϴ���С���ó���500K
					if(attachs.getSize()>fileSize){
						request.setAttribute(errorinfo, "�ϴ��ļ����ô���500k");
						flag = false;
					}else if(prefixName.equalsIgnoreCase("jpg")
							|| prefixName.equalsIgnoreCase("png")
							|| prefixName.equalsIgnoreCase("jpeg")
							|| prefixName.equalsIgnoreCase("pneg")){
						//�ж��ϴ���ʽ
						//�����µ��ļ�������ǰϵͳʱ��+�����+�̶���׺��
						//RandomUtils��Ҫ����jar�ļ�commons-lang.jar
//						String fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"personer.jpg";
						String fileName = System.currentTimeMillis()+"personer.jpg";
						//�����µ��ļ������ڽ����û��ϴ����ļ���
						File targetFile = new File(path, fileName);
						if(!targetFile.exists()){
							targetFile.mkdirs();
						}
						
						//���ϴ����ļ�����
						try {
							attachs.transferTo(targetFile);
						} catch (Exception e) {
							e.printStackTrace();
							request.setAttribute(errorinfo,"�ϴ�ʧ�ܣ�");
							flag = false;
						} 
						
						//�����ϴ���·��
						spicpath = path + File.separator + fileName;
						
						
					}else{
						request.setAttribute(errorinfo,"ͼƬ��ʽ����ȷ��");
						flag = false;
					}
						
				   }
				
			
				
				
				//׼��User
				if(flag){
					
					shangp.setPicpath(spicpath);
					shangp.setShangid(Integer.parseInt(shangid));
//					shangp.setGoodid(goodid);
//					shangp.setPrice(price);
//					shangp.setRestcount(restcount);
//					shangp.setShangdic(shangdic);
//					shangp.setShangname(shangname);
					
					if(shangpService.findUpdShangp(shangp)>0){
						
						return "redirect:/shangp/page?usecurrentPage=-1";
					}
				}
				
		
		return "manager/product-add.jsp";
	}
	
	
	
	
	/*
	 * 
	 * �����Ʒ
	 */
	@RequestMapping(value="/addshang",method=RequestMethod.POST)
	public String doAddShangp(Shangp shangp,HttpServletRequest request,
			                  @RequestParam(value="attachs",required=false)MultipartFile attachs){
		        
		        //Shangp shangp = new Shangp();
		        //���������ϴ��ļ���·��
				String spicpath = null;
				String errorinfo = "uploadspError";
				//�����ϴ����̹�����
				boolean flag = true;
				//�����ļ������λ��
				String path = request.getSession().getServletContext().getRealPath("statics"+File.separator+"uploadfiles");
				
					//�ж��ļ��Ƿ�Ϊ��
					if(!attachs.isEmpty()){
						
					//��ȡԴ�ļ���
					String oldName= attachs.getOriginalFilename();
					//��ȡԴ�ļ�����׺
					String prefixName = FilenameUtils.getExtension(oldName);
					
					int fileSize = 500000;
					//�ж��ϴ���С���ó���500K
					if(attachs.getSize()>fileSize){
						request.setAttribute(errorinfo, "�ϴ��ļ����ô���500k");
						flag = false;
					}else if(prefixName.equalsIgnoreCase("jpg")
							|| prefixName.equalsIgnoreCase("png")
							|| prefixName.equalsIgnoreCase("jpeg")
							|| prefixName.equalsIgnoreCase("pneg")){
						//�ж��ϴ���ʽ
						//�����µ��ļ�������ǰϵͳʱ��+�����+�̶���׺��
						//RandomUtils��Ҫ����jar�ļ�commons-lang.jar
//						String fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"personer.jpg";
						String fileName = System.currentTimeMillis()+"personer.jpg";
						//�����µ��ļ������ڽ����û��ϴ����ļ���
						File targetFile = new File(path, fileName);
						if(!targetFile.exists()){
							targetFile.mkdirs();
						}
						
						//���ϴ����ļ�����
						try {
							attachs.transferTo(targetFile);
						} catch (Exception e) {
							e.printStackTrace();
							request.setAttribute(errorinfo,"�ϴ�ʧ�ܣ�");
							flag = false;
						} 
						
						//�����ϴ���·��
						spicpath = fileName;
						
						
					}else{
						request.setAttribute(errorinfo,"ͼƬ��ʽ����ȷ��");
						flag = false;
					}
						
				   }
				
			
				
				
				//׼��User
				if(flag){
					
					shangp.setPicpath(spicpath);
//					shangp.setGoodid(goodid);
//					shangp.setPrice(price);
//					shangp.setRestcount(restcount);
//					shangp.setShangdic(shangdic);
//					shangp.setShangname(shangname);
					
					if(shangpService.findAddShangp(shangp)>0){
						
						return "redirect:/shangp/page?usecurrentPage=-1";
					}
				}
			
		return "manager/product-add.jsp";
	}
	

	/*
	 * 
	 * ɾ����Ʒ��¼(shangid)
	 */
	@RequestMapping(value="/del",params={"shangid","usecurrentPage"})
	public String doDelShangp(@RequestParam("shangid")String shangid,
			                  @RequestParam("usecurrentPage")String usecurrentPage){
		
		if(buyCarService.findDelBuyCar2(Integer.parseInt(shangid))>=0){
			if(detailsService.findDelDetails2(Integer.parseInt(shangid))>=0){
				if(shangpService.findDelShangp(Integer.parseInt(shangid))>0){
					return "redirect:/shangp/page?usecurrentPage="+usecurrentPage;
				}
			}
		}
		
		return "manager/error.jsp";
	}	
	
	
	
	
	
	
}
