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
	 * 分页显示product-list的商品
	 */
	@RequestMapping(value="/list",params={"goodid","currentPage"})
	public ModelAndView getShangpList(@RequestParam(value="goodid")int goodid,
			                          @RequestParam(value="currentPage")int currentPage){
		ModelAndView mandv = new ModelAndView();
		List<Shangp> productList = new ArrayList<Shangp>();
		//判断是否从左侧导航查看product
		if(currentPage==-1){
			currentPage=1;
			pageMap.put("currentPage", 1);
			//查询总页数，存入模型
			int totalPage=0;
			int count  = shangpService.getShangpCount(goodid);
			totalPage = (count%3==0?count/3:(count/3+1));
			pageMap.put("totalPage", totalPage);
		}else{
			pageMap.put("currentPage", currentPage);
		}
		pageMap.put("goodid", goodid);
		pageMap.put("usecurrentPage", (currentPage-1)*3);
		//根据goodid查询shangplist
		productList = shangpService.getProductShangp(pageMap);
		mandv.addObject("productList", productList);
		mandv.addObject("pageMap", pageMap);
		mandv.setViewName("shangp/product-list.jsp");
		return mandv;
	}
	
	
	/*
	 * 分页显示大类的商品
	 */
	@RequestMapping(value="/fatherlist",params={"fatherid","currentPage"})
	public ModelAndView doFatherList(@RequestParam(value="fatherid")int fatherid,
			                          @RequestParam(value="currentPage")int currentPage){
		ModelAndView mandv = new ModelAndView();
		List<Shangp> productList = new ArrayList<Shangp>();
		//判断是否从左侧导航查看product
		if(currentPage==-1){
			currentPage=1;
			pageMap.put("currentPage", 1);
			//查询总页数，存入模型
			int totalPage=0;
			int count  = shangpService.findFatherCount(fatherid);
			totalPage = (count%3==0?count/3:(count/3+1));
			pageMap.put("totalPage", totalPage);
		}else{
			pageMap.put("currentPage", currentPage);
		}
		pageMap.put("fatherid", fatherid);
		pageMap.put("usecurrentPage", (currentPage-1)*3);
		//根据goodid查询shangplist
		productList = shangpService.findFatherShangp(pageMap);
		mandv.addObject("productList", productList);
		mandv.addObject("pageMap", pageMap);
		mandv.setViewName("shangp/product-list.jsp");
		return mandv;
	}
	
	
	
	
	
	/*
	 * 后台商品管理，分页显示全部商品
	 */
	@RequestMapping(value="/page",params="usecurrentPage")
	public String doShangp(@RequestParam(value="usecurrentPage")int usecurrentPage,Model model){
		//第一次进入分页显示
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
	 * 查询单件商品详情
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
	 * 后台修改单件商品详情
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
	 * 修改商品信息
	 */
	@RequestMapping(value="/upd",method=RequestMethod.POST)
	public String doUpdShangp(Shangp shangp,HttpServletRequest request,
			                  @RequestParam(value="attachs",required=false)MultipartFile attachs,
			                  @RequestParam(value="shangid")String shangid){
		        
		        //Shangp shangp = new Shangp();
		        //定义两个上传文件的路径
				String spicpath = null;
				String errorinfo = "uploadspError";
				//定义上传过程管理标记
				boolean flag = true;
				//定义文件保存的位置
				String path = request.getSession().getServletContext().getRealPath("statics"+File.separator+"uploadfiles");
				
					//判断文件是否为空
					if(!attachs.isEmpty()){
						
					//获取源文件名
					String oldName= attachs.getOriginalFilename();
					//获取源文件名后缀
					String prefixName = FilenameUtils.getExtension(oldName);
					
					int fileSize = 500000;
					//判断上传大小不得超过500K
					if(attachs.getSize()>fileSize){
						request.setAttribute(errorinfo, "上传文件不得大于500k");
						flag = false;
					}else if(prefixName.equalsIgnoreCase("jpg")
							|| prefixName.equalsIgnoreCase("png")
							|| prefixName.equalsIgnoreCase("jpeg")
							|| prefixName.equalsIgnoreCase("pneg")){
						//判断上传格式
						//定义新的文件名，当前系统时间+随机数+固定后缀，
						//RandomUtils需要引入jar文件commons-lang.jar
//						String fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"personer.jpg";
						String fileName = System.currentTimeMillis()+"personer.jpg";
						//创建新的文件，用于接收用户上传的文件流
						File targetFile = new File(path, fileName);
						if(!targetFile.exists()){
							targetFile.mkdirs();
						}
						
						//将上传的文件保存
						try {
							attachs.transferTo(targetFile);
						} catch (Exception e) {
							e.printStackTrace();
							request.setAttribute(errorinfo,"上传失败！");
							flag = false;
						} 
						
						//更新上传的路径
						spicpath = path + File.separator + fileName;
						
						
					}else{
						request.setAttribute(errorinfo,"图片格式不正确！");
						flag = false;
					}
						
				   }
				
			
				
				
				//准备User
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
	 * 添加商品
	 */
	@RequestMapping(value="/addshang",method=RequestMethod.POST)
	public String doAddShangp(Shangp shangp,HttpServletRequest request,
			                  @RequestParam(value="attachs",required=false)MultipartFile attachs){
		        
		        //Shangp shangp = new Shangp();
		        //定义两个上传文件的路径
				String spicpath = null;
				String errorinfo = "uploadspError";
				//定义上传过程管理标记
				boolean flag = true;
				//定义文件保存的位置
				String path = request.getSession().getServletContext().getRealPath("statics"+File.separator+"uploadfiles");
				
					//判断文件是否为空
					if(!attachs.isEmpty()){
						
					//获取源文件名
					String oldName= attachs.getOriginalFilename();
					//获取源文件名后缀
					String prefixName = FilenameUtils.getExtension(oldName);
					
					int fileSize = 500000;
					//判断上传大小不得超过500K
					if(attachs.getSize()>fileSize){
						request.setAttribute(errorinfo, "上传文件不得大于500k");
						flag = false;
					}else if(prefixName.equalsIgnoreCase("jpg")
							|| prefixName.equalsIgnoreCase("png")
							|| prefixName.equalsIgnoreCase("jpeg")
							|| prefixName.equalsIgnoreCase("pneg")){
						//判断上传格式
						//定义新的文件名，当前系统时间+随机数+固定后缀，
						//RandomUtils需要引入jar文件commons-lang.jar
//						String fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"personer.jpg";
						String fileName = System.currentTimeMillis()+"personer.jpg";
						//创建新的文件，用于接收用户上传的文件流
						File targetFile = new File(path, fileName);
						if(!targetFile.exists()){
							targetFile.mkdirs();
						}
						
						//将上传的文件保存
						try {
							attachs.transferTo(targetFile);
						} catch (Exception e) {
							e.printStackTrace();
							request.setAttribute(errorinfo,"上传失败！");
							flag = false;
						} 
						
						//更新上传的路径
						spicpath = fileName;
						
						
					}else{
						request.setAttribute(errorinfo,"图片格式不正确！");
						flag = false;
					}
						
				   }
				
			
				
				
				//准备User
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
	 * 删除商品记录(shangid)
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
