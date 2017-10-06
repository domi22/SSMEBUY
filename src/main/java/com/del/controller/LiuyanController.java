package com.del.controller;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.del.pojo.Liuyan;
import com.del.service.LiuyanService;

@Controller("liuyanController")
@RequestMapping("/liuyan")
public class LiuyanController {

	@Autowired
	@Qualifier("liuyanService")
	private LiuyanService liuyanService;
	
	
	/*
	 * 进入留言管理页面，分页显示
	 */
	@RequestMapping("/page")
	public String  doAllLiuyan(@RequestParam(value="currentPage")Integer currentPage,Model model){
		if(currentPage==-1){
			currentPage = 1;
		}
		model.addAttribute("currentPage", currentPage);
		int newcurrentPage = (currentPage-1)*3;
		int count = liuyanService.findCountLiuyan();
		if(count>=0){
			int totalPage = count%3==0?count/3:(count/3+1);
			model.addAttribute("totalPage", totalPage);
			List<Liuyan> liuyanlist = liuyanService.findAllLiuyan(newcurrentPage);
			model.addAttribute("liuyanlist", liuyanlist);
			
			return "manager/guestbook.jsp";
		}		
		return "manager/error.jsp";
		
	}

	/*
	 * 删除留言
	 */
	@RequestMapping("/del")
	public String  doDelLiuyan(@RequestParam(value="currentPage")Integer currentPage,Model model,
			                   @RequestParam(value="lyid")Integer lyid){
		
		if(liuyanService.findDelLiuyan(lyid)>0){
			
			return "redirect:/liuyan/page?currentPage="+currentPage;
			
		}
        return "manager/error.jsp";	
	}
	
	
	
	/*
	 *  前台展示最近的3条留言记录
	 */
	@RequestMapping("/pageweb")
	public String  doPagewebLiuyan(@RequestParam(value="currentPage")Integer currentPage,Model model){
		
		if(currentPage==-1){
			currentPage = 1;
		}
		
		model.addAttribute("currentPage", currentPage);
		int newcurrentPage = (currentPage-1)*3;
		int count = liuyanService.findCountLiuyan();
		
		if(count>=0){
			int totalPage = count%3==0?count/3:(count/3+1);
			model.addAttribute("totalPage", totalPage);
			ArrayList<Liuyan> liuyanlist = liuyanService.findWebLiuyan(newcurrentPage);
			model.addAttribute("webliuyanlist", liuyanlist);
			
			return "liuyan/guestbook.jsp";
		}	
		
		return "manager/error.jsp";
	}
	
	
	@RequestMapping("/add")
	public String doAddLiuyan(Liuyan liuyan,
			                  @RequestParam(value="currentPage")Integer currentPage){
	
		if(liuyanService.findAddLiuyan(liuyan)>0){
			
			return "redirect:/liuyan/pageweb?currentPage="+currentPage;
		}
		
		return "manager/error.jsp";
	}
	
	
}
