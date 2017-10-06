package com.del.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.del.pojo.Indent;
import com.del.service.DetailsService;
import com.del.service.IndentService;
import com.del.service.T_statusService;
import com.del.service.UserService;


@Controller
@RequestMapping("/indent")
public class IndentController {

	
	
	@Resource(name="indentService")
	private IndentService indentService;
	@Resource(name="detailsService")
	private DetailsService detailsService;
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="t_statusService")
	private T_statusService t_statusService;
	
	

	/*
	 * 分页显示
	 */
	@RequestMapping("/page")
	public String doAllIndent(@RequestParam(value="usecurrentPage")int usecurrentPage,Model model){
		
		if(usecurrentPage==-1){
			usecurrentPage = 1;
		}
		int newusecurrentPage = (usecurrentPage-1)*3;
		int count = indentService.findCountIndent();
		int totalPage = count%3==0?count/4:(count/4+1);
		List<Indent> indetlist = indentService.findAllIndent(newusecurrentPage);
		model.addAttribute("indetlist", indetlist);
		model.addAttribute("usecurrentPage", usecurrentPage);
		model.addAttribute("totalPage", totalPage);
		return "manager/order.jsp";
			
	}
	
	
	
	
	
	/*
	 * 指定查询分页显示
	 */
	@RequestMapping(value="/searchpage",method=RequestMethod.POST)
	public String doSomIndent(@RequestParam(value="usecurrentPage")Integer usecurrentPage,Model model,
			                  @RequestParam(value="indentid")Integer indentid,
			                  @RequestParam(value="username")String username){
		
		if(usecurrentPage==-1){
			usecurrentPage = 1;
		}
		int newusecurrentPage = (usecurrentPage-1)*3;
		List<Indent> indetlist = indentService.findSomIndent(newusecurrentPage, indentid, username);
		
		int count = indetlist.size();
		int totalPage = count%3==0?count/4:(count/4+1);
		
		model.addAttribute("indetlist", indetlist);
		model.addAttribute("usecurrentPage", usecurrentPage);
		model.addAttribute("totalPage", totalPage);
		return "manager/order.jsp";
	}
	
	
	
	/*
	 * indentid删除记录
	 */
	@RequestMapping(value="/del",params={"indentid","usecurrentPage"})
	public String doDelIndent2(@RequestParam(value="usecurrentPage")Integer usecurrentPage,
			                   @RequestParam(value="indentid")Integer indentid){
	
		
		
		if(detailsService.findDelDetails3(indentid)>=0){
			
			if(indentService.findDelIndent2(indentid)>0){
			
				return "redirect:/indent/page?usecurrentPage="+usecurrentPage;
			}
		}
		
		
		return "manager/error.jsp";
	}
	
	
	
	/*
	 * mdf记录
	 */
	@RequestMapping(value="/tomdf")
	public String doToMdfIndent(@RequestParam(value="usecurrentPage")Integer usecurrentPage,
			                  @RequestParam(value="indentid")Integer indentid,
			                  @RequestParam(value="username")String username,
			                  @RequestParam(value="phone")String phone,
			                  @RequestParam(value="address")String address,
			                  @RequestParam(value="statusname")String statusname,
			                  Model model){
		
		model.addAttribute("usecurrentPage", usecurrentPage);
		model.addAttribute("indentid", indentid);
		model.addAttribute("username", username);
		model.addAttribute("phone", phone);
		model.addAttribute("address", address);
		model.addAttribute("statusname", statusname);
		
		return "manager/order-modify.jsp";
	}
	
	
	
	@RequestMapping(value="/mdf")
	public String doMdfIndent(@RequestParam(value="usecurrentPage")Integer usecurrentPage,
			                  @RequestParam(value="indentid")Integer indentid,
			                  @RequestParam(value="username")String username,
			                  @RequestParam(value="phone")String phone,
			                  @RequestParam(value="address")String address,
			                  @RequestParam(value="statusname")String statusname){
		
		//修改user表的字段
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("indentid", indentid);
		map.put("username", username);
		map.put("phone", phone);
		map.put("address", address);
		if(userService.findUpdUser2(map)>0){
			//修改状态表的字段
			if(t_statusService.findUpdT_status(indentid, statusname)>0){
				
				return "redirect:/indent/page?usecurrentPage="+usecurrentPage;
				
			}
		}
		
		return "manager/error.jsp";
	}
	
	
	
}
