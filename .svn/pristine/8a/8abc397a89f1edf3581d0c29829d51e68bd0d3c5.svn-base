package com.del.controller;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
//import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import com.del.pojo.Goods;
import com.del.pojo.News;
import com.del.pojo.Notice;
import com.del.pojo.Shangp;
import com.del.pojo.User;
import com.del.service.BuyCarService;
import com.del.service.DetailsService;
import com.del.service.IndentService;
import com.del.service.NewsService;
import com.del.service.NoticeService;
import com.del.service.ShangpService;
import com.del.service.UserService;
import com.del.tools.CaptchaUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Resource(name="userService")
	private UserService userService;
	@Resource
	private ShangpService shangpService;
	@Resource
	private NoticeService noticeService;
	@Resource
	private NewsService newsService;
	@Resource
	private IndentService indentService;
	@Resource(name="buyCarService")
	private BuyCarService buyCarService;
	@Resource(name="detailsService")
	private DetailsService detailsService;
	
	
	
	@RequestMapping("/index")
	public ModelAndView getLeftList(HttpSession session){
		List<Goods> listlest = new ArrayList<Goods>();
		List<Shangp> centerList = new ArrayList<Shangp>();
		List<Notice> rightNoticeList = new ArrayList<Notice>();
		List<News> rightNewsList = new ArrayList<News>();
		ModelAndView leftModelview  = new ModelAndView();
		//获取左边的导航列表
		listlest = userService.findGoods();
		//获取中间的商品
		centerList = shangpService.getCenterShang();
		//获取最新公告列表
		rightNoticeList = noticeService.getNoticeList();
		//获取新闻动态列表
		rightNewsList = newsService.getNewsList();
		
		session.setAttribute("leftList", listlest);
		leftModelview.addObject("centerList", centerList);
		leftModelview.addObject("rightNoticeList", rightNoticeList);
		leftModelview.addObject("rightNewsList", rightNewsList);
		leftModelview.setViewName("index/index.jsp");
		
		return leftModelview;
	}
	
		/*
		 * 验证码请求
		 * 
		 */
	    @RequestMapping(value = "/captcha", method = RequestMethod.GET)
	    @ResponseBody
	    public void captcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	        CaptchaUtil.outputCaptcha(request, response);
	    }
	
	
	
	
	
	
	
	
	
	/*
	 * 登录验证
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String doLogin(@RequestParam(value="userName")String userName,
			              @RequestParam(value="passWord")String passWord,
			              @RequestParam(value="veryCode")String veryCode,
			              HttpSession session){
		
		
		String vCode = (String)session.getAttribute("randomString");
		
		User user=null;
		if(userName!=null &&
				!"".equals(userName) &&
				passWord!=null &&
				!"".equals(passWord) &&
				vCode.equals(veryCode)){
		
		   user = userService.findLoginUser(userName, passWord);
	    }
		if(user!=null){
			
			session.setAttribute("hasLogin", user);
			if(user.getUserrole()==1){
				return "redirect:/index/index";
			}else{
				return "manager/index.jsp";
			}
			
		}else{
		    return "index/login.jsp";
		}
		
	}
	
	
	/*
	 * 退出登录
	 */
	@RequestMapping("logout")
	public String doLogout(HttpSession session){
		session.removeAttribute("hasLogin");
		return "redirect:/index/index";
	}
	
	
	/*
	 * 用户注册
	 */
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String doLogin(@RequestParam(value="regUserName")String regUserName,
			              @RequestParam(value="passWord")String passWord,
			              @RequestParam(value="address")String address,
			              @RequestParam(value="phone")String phone,
			              @RequestParam(value="email")String email,
			              @RequestParam(value="sex")String sex,
			              @RequestParam(value="veryCode")String veryCode,
			              HttpSession session){
		
		String vCode = (String)session.getAttribute("randomString");
		if(vCode.equals(veryCode)){
			User user = new User();
			user.setAddress(address);
			user.setEmail(email);
			//user.setBirthday(new Date("1998-09-06"));
			user.setPhone(phone);
			user.setPwd(passWord);
			//user.setHdpicpath("0.jpg");
			user.setSex(sex);
			user.setUsername(regUserName);
			user.setUserrole(1);
			int insertnum = userService.findRegister(user);
			if(insertnum>0){
				return "index/reg-result.jsp";
			}else{
				return "index/register.jsp";
			}	
		}
		
		return "index/register.jsp";
		
	}
	
	
	 /*
	  *验证用户名是否可用
	  */
	@RequestMapping(value="hasname",method=RequestMethod.POST)
	@ResponseBody
	public Object doHasName(@RequestParam(value="username")String username){
		
		if(username!=null && !"".equals(username)){
			int hasname = userService.findHasName(username);
			if(hasname>0){
				return JSON.toJSONString("1");
			}
		}
		
		return JSON.toJSONString("0");
	}
	
	
	 /*
	  *判断用户是否登录
	  */
	@RequestMapping(value="/haslogin",params="opr")
	public String hasLogin(@RequestParam(value="opr")String opr,HttpSession session){
		User user = (User)session.getAttribute("hasLogin");
		if(user!=null){
			
			//返回到购物车页面
			if("index_buycar".equals(opr))    return "redirect:/buycar/list";
			if("shopping_buycar".equals(opr)) return "redirect:/buycar/list";
			if("login_buycar".equals(opr))    return "redirect:/buycar/list";
			if("register_buycar".equals(opr)) return "redirect:/buycar/list";
			if("product_buycar".equals(opr))  return "redirect:/buycar/list";
			if("sp_result_buycar".equals(opr))return "redirect:/buycar/list";
			if("reg_buycar".equals(opr))      return "redirect:/buycar/list";
			if("guestbook_buycar".equals(opr))return "redirect:/buycar/list";
			if("register_buycar".equals(opr)) return "redirect:/buycar/list";
			if("pro_view_buycar".equals(opr)) return "redirect:/buycar/list";
			
			//返回到留言页面
			if("sp_result_liuyan".equals(opr)) return "liuyan/guestbook.jsp";
			if("shopping_liuyan".equals(opr))  return "liuyan/guestbook.jsp";
			if("index_liuyan".equals(opr))     return "liuyan/guestbook.jsp";
			if("login_liuyan".equals(opr))     return "liuyan/guestbook.jsp";
			if("reg_liuyan".equals(opr))       return "liuyan/guestbook.jsp";
			if("guestbook_liuyan".equals(opr)) return "liuyan/guestbook.jsp";
			if("product_liuyan".equals(opr))   return "liuyan/guestbook.jsp";
			if("pro_view_liuyan".equals(opr))  return "liuyan/guestbook.jsp";
			
		}
		
		return "index/login.jsp";
	}
	
	
	/*
	 * jsp访问jsp的中转
	 */
	@RequestMapping(value="zzz",params="opr")
	public String doZzz(@RequestParam(value="opr")String opr){
		return opr;
	}
	
	
	/*
	 * 展示用户列表管理  
	 */
	@RequestMapping(value="/user")
	public String doUserList(@RequestParam(value="currentPage")String currentPage,Model model){
		
		if(Integer.parseInt(currentPage)==1){
			PageHelper.startPage(1,7);
		}
		PageHelper.startPage(Integer.parseInt(currentPage),7);
		List<User> userlist = userService.findUserList();
		PageInfo<User> info = new PageInfo<User>(userlist);
		
		
		/*System.out.println("totol======="+info.getTotal());
		System.out.println("EndRow======="+info.getEndRow());
		System.out.println("FirstPage======="+info.getFirstPage());
		System.out.println("LastPage======="+info.getLastPage());
		System.out.println("NavigatePages======="+info.getNavigatePages());
		System.out.println("NavigatepageNums======="+info.getNavigatepageNums());
		System.out.println("PageSize======="+info.getPageSize());
		System.out.println("Size======="+info.getSize());
		System.out.println("PrePage======="+info.getPrePage());
		System.out.println("StartRow======="+info.getStartRow());
		System.out.println("Pages======="+info.getPages());
		System.out.println("OrderBy======="+info.getOrderBy());
		System.out.println("NextPage======="+info.getNextPage());
		System.out.println("List======="+info.getList());
		System.out.println("LastPage======="+info.getLastPage());
		System.out.println("FirstPage======="+info.getFirstPage());
		System.out.println("isIsFirstPage()======="+info.isIsFirstPage());
		System.out.println("isHasNextPage()======="+info.isHasNextPage());
		System.out.println("isHasPreviousPage()======="+info.isHasPreviousPage());
		System.out.println("PageNum()======="+info.getPageNum());*/
		
		
//		PageInfo<T> pageInfo = new PageInfo(userlist);
		//mView.addObject("userlist", userlist);
		//mView.setViewName("manager/user");
		model.addAttribute("userlist", userlist);
		model.addAttribute("page", info);
		return "manager/user.jsp";	
		
	}
	
	/*
	 * 根据userid删除用户
	 */
	@RequestMapping(value="/del")
	public String doDelUserAdel(@RequestParam("userid")int userid,@RequestParam("currentPage")String currentPage){
		//根据userid删除details表记录
		detailsService.findDelDetails(userid);
		//根据userid删除indent表记录
		indentService.findDelIndent(userid);
		//根据userid删除buycar表记录
		buyCarService.findDelBuyCar1(userid);
		//根据userid删除user表记录
		userService.findDelUser(userid);
		
		return "redirect:/index/user?currentPage="+currentPage;
	}
	
	
	
	/*
	 * 管理员新增用户
	 */
	@RequestMapping(value="/newadd",method=RequestMethod.POST)
	public String doAddUser(HttpSession session,HttpServletRequest request,
			                @RequestParam(value="attachs",required=false)MultipartFile[] attachs,
			                User user){
	
		//定义两个上传文件的路径
		String wkpicpath = null;
		String hdpicpath = null;
		String errorinfo = null;
		//定义上传过程管理标记
		boolean flag = true;
		//定义文件保存的位置
		String path = request.getSession().getServletContext().getRealPath("statics"+File.separator+"uploadfiles");
		//循环读取文件信息
		for(int i=0;i<attachs.length;i++){
			MultipartFile attach = attachs[i];
			//判断文件是否为空
			if(!attach.isEmpty()){
				//判断是第几个文件
				if(i==0){
					errorinfo = "uploadwkError";
				}else if(i==1){
					errorinfo = "uploadhdError";
				}
			//获取源文件名
			String oldName= attach.getOriginalFilename();
			//获取源文件名后缀
			String prefixName = FilenameUtils.getExtension(oldName);
			
			int fileSize = 500000;
			//判断上传大小不得超过500K
			if(attach.getSize()>fileSize){
				session.setAttribute(errorinfo, "上传文件不得大于500k");
				flag = false;
			}else if(prefixName.equalsIgnoreCase("jpg")
					|| prefixName.equalsIgnoreCase("png")
					|| prefixName.equalsIgnoreCase("jpeg")
					|| prefixName.equalsIgnoreCase("pneg")){
				//判断上传格式
				//定义新的文件名，当前系统时间+随机数+固定后缀，
				//RandomUtils需要引入jar文件commons-lang.jar
//				String fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"personer.jpg";
				String fileName = System.currentTimeMillis()+"personer.jpg";
				//创建新的文件，用于接收用户上传的文件流
				File targetFile = new File(path, fileName);
				if(!targetFile.exists()){
					targetFile.mkdirs();
				}
				
				//将上传的文件保存
				try {
					attach.transferTo(targetFile);
				} catch (Exception e) {
					e.printStackTrace();
					session.setAttribute(errorinfo,"上传失败！");
					flag = false;
				} 
				
				//更新上传的路径
				if(i==0){
					wkpicpath = fileName;
				}else if(i==1){
					hdpicpath = fileName;
				}
				
			}else{
				session.setAttribute(errorinfo,"图片格式不正确！");
				flag = false;
			}
				
		   }
		
		}
		
		
		//准备User
		if(flag){
			user.setWkpicpath(wkpicpath);
			user.setHdpicpath(hdpicpath);
			user.setUserrole(1);
			if(userService.findAddUser(user)>0){
				
				return "redirect:/index/user?currentPage=1";
			}
			
		}
		
		
		return "manager/user-add.jsp";
	}
	
	
	/*
	 * 管理修改增用户（带附件上传）
	 */
	@RequestMapping(value="/upd",method=RequestMethod.POST)
	public String doUpdUser(HttpSession session,HttpServletRequest request,
			                @RequestParam(value="attachs",required=false)MultipartFile[] attachs,
			                User user,@RequestParam(value="currentPage")String currentPage,Model model){
		
		
		
		//定义两个上传文件的路径
		String wkpicpath = null;
		String hdpicpath = null;
		String errorinfo = null;
		//定义上传过程管理标记
		boolean flag = true;
		//定义文件保存的位置
		String path = request.getSession().getServletContext().getRealPath("statics"+File.separator+"uploadfiles");
		System.out.println(path);
		//循环读取文件信息
		for(int i=0;i<attachs.length;i++){
			MultipartFile attach = attachs[i];
			//判断文件是否为空
			if(!attach.isEmpty()){
				//判断是第几个文件
				if(i==0){
					errorinfo = "uploadwkError";
				}else if(i==1){
					errorinfo = "uploadhdError";
				}
			//获取源文件名
			String oldName= attach.getOriginalFilename();
			//获取源文件名后缀
			String prefixName = FilenameUtils.getExtension(oldName);
			
			int fileSize = 500000;
			//判断上传大小不得超过500K
			if(attach.getSize()>fileSize){
				session.setAttribute(errorinfo, "上传文件不得大于500k");
				flag = false;
			}else if(prefixName.equalsIgnoreCase("jpg")
					|| prefixName.equalsIgnoreCase("png")
					|| prefixName.equalsIgnoreCase("jpeg")
					|| prefixName.equalsIgnoreCase("pneg")){
				//判断上传格式
				//定义新的文件名，当前系统时间+随机数+固定后缀，
				//RandomUtils需要引入jar文件commons-lang.jar
//				String fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"personer.jpg";
				String fileName = System.currentTimeMillis()+"personer.jpg";
				//创建新的文件，用于接收用户上传的文件流
				File targetFile = new File(path, fileName);
				if(!targetFile.exists()){
					targetFile.mkdirs();
				}
				
				//将上传的文件保存
				try {
					attach.transferTo(targetFile);
				} catch (Exception e) {
					e.printStackTrace();
					session.setAttribute(errorinfo,"上传失败！");
					flag = false;
				} 
				
				//更新上传的路径
				if(i==0){
					wkpicpath = fileName;
				}else if(i==1){
					hdpicpath =  fileName;
					
				}
				
			}else{
				session.setAttribute(errorinfo,"图片格式不正确！");
				flag = false;
			}
				
		   }
		
		}
		
		
		//准备User
		if(flag){
			
			user.setWkpicpath(wkpicpath);
			user.setHdpicpath(hdpicpath);
			user.setUserrole(1);
			
			if(userService.findUpdUser(user)>0){
				
				return "redirect:/index/user?currentPage="+currentPage;
			}
			
		}
		
		model.addAttribute("currentPage", currentPage);
		
		return "manager/user-add.jsp";
	}
	
	
	/*
	 * 根据userid得到user信息
	 */
	@RequestMapping(value="/showuser")
	public String doUser(@RequestParam(value="userid")int userid,Model model,
			             @RequestParam(value="currentPage")String currentPage){
	   
		User user = userService.findUser(userid);
	    if(user!=null){
	    	
	    	model.addAttribute("showuser",user );
	    	model.addAttribute("currentPage",currentPage);
	    }
		 
		return "manager/user-modify.jsp";
	}
	
	/*
	 * 
	 * 删除分类
	 */
	@RequestMapping(value="/delgood",params="goodid")
	public String doDelGood(@RequestParam("goodid")String goodid,HttpSession session){
		 
		int newgoodid = Integer.parseInt(goodid);
		if(shangpService.findDelgoodid(newgoodid)>=0){
			
			if(userService.findDelGood(newgoodid)>0){
				
				session.setAttribute("leftList", userService.findGoods());
				
			 return "redirect:/index/togood";
			}
		}
		
		return "manager/error.jsp";
	}
	
	
	/*
	 * 
	 * 请求商品分类页面
	 */
	@RequestMapping("/togood")
	public String doToGood(HttpSession session){
		
		session.setAttribute("leftList", userService.findGoods());
		
		return "manager/productClass.jsp";
	}
	
	
	
	/*
	 * 
	 * 请求修改分类页面
	 */
	@RequestMapping(value="/tomdf",params="goodid")
	public String doToMdf(@RequestParam(value="goodid")String goodid,Model model,HttpSession session){
		
		model.addAttribute("oneGood", userService.findOneGood(Integer.parseInt(goodid)));
		//更新session中的goodlist
		session.setAttribute("leftList", userService.findGoods());
		return "manager/productClass-modify.jsp";
	}
	
	
	
	/*
	 * 
	 * 处理修改分类页面
	 */
	@RequestMapping(value="/mdf")
	public String doMdf(Goods goods,HttpSession session){
		
		if(userService.findMdfGood(goods)>0){
			//更新session中的goodlist
			session.setAttribute("leftList", userService.findGoods());
			return "manager/productClass.jsp";
		}
		
		return "manager/error.jsp";
	}
	
	
	
	/*
	 * 
	 * 请求添加分类页面
	 */
	@RequestMapping(value="/toclassadd")
	public String doClassAdd(HttpSession session){
		
			session.setAttribute("leftList", userService.findGoods());
		
			return "manager/productClass-add.jsp";
	}
	
	
	/*
	 * 
	 * 处理添加分类页面
	 */
	@RequestMapping(value="/classadd")
	public String doAdd(Goods goods,HttpSession session){
		
		    if(userService.findAddGood(goods)>0){
		    	session.setAttribute("leftList", userService.findGoods());
		    	return "manager/productClass.jsp";
		    }
		    
			
		    return "manager/error.jsp";
			
	}
	
	

}
