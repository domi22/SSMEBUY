package com.del.controller;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.del.pojo.Liuyan;
import com.del.pojo.News;
import com.del.pojo.Notice;
import com.del.service.NewsService;
import com.del.service.NoticeService;


@Controller
@RequestMapping("/news")
public class NewsController {

	@Resource(name="newsService")
	private NewsService newsService;
	@Resource(name="noticeService")
	private NoticeService noticeService;
	
	
	
	/*
	 *��̨��ȡ�����б� 
	 * 
	 */
	@RequestMapping("/page")
	public String doPageList(@RequestParam(value="currentPage")Integer currentPage,Model model){
		if(currentPage==-1){
			currentPage = 1;
		}
		model.addAttribute("currentPage", currentPage);
		int newcurrentPage = (currentPage-1)*3;
		int count = newsService.findCountList();
		if(count>=0){
			int totalPage = count%3==0?count/3:(count/3+1);
			model.addAttribute("totalPage", totalPage);
			List<News> newslist = newsService.getPageNews(newcurrentPage);
			model.addAttribute("newslist", newslist);
			return "manager/news.jsp";
			
		}
		
		return "manager/error.jsp";
	}
	
	
	/*
	 * ����newsid��ѯ������Ϣ
	 */
	@RequestMapping(value="/view")
	public String doNewsView(@RequestParam(value="newid")Integer newid,Model model){
		News news = newsService.findNew(newid);
		model.addAttribute("news", news);
		model.addAttribute("rightNoticeList", noticeService.getNoticeList());
		model.addAttribute("rightNewsList", newsService.getNewsList());
		
		return "news/news-view.jsp";
	}
	
	
	/*
	 * ����newsid��ѯ������Ϣ
	 */
	@RequestMapping(value="/noticeview")
	public String doNoticeView(@RequestParam(value="noticeid")Integer noticeid,Model model){
		Notice notice = noticeService.findNotice(noticeid);
		model.addAttribute("notice", notice);
		model.addAttribute("rightNoticeList", noticeService.getNoticeList());
		model.addAttribute("rightNewsList", newsService.getNewsList());
		
		return "notice/notice-view.jsp";
	}
	
	
	
	
	
	
	/*
	 * ����newsidɾ��������Ϣ
	 */
	@RequestMapping(value="/del")
	public String doDelNews(@RequestParam(value="newid")Integer newid,
			                @RequestParam(value="currentPage")Integer currentPage){
		if(newsService.findDel(newid)>0){
			return "redirect:/news/page?currentPage="+currentPage;
		}
		
		return "manager/error.jsp";
	}
	
	
	/*
	 * ����newsid��ȡ������Ϣ
	 */
	@RequestMapping(value="/mdf")
	public String doMdfNews(@RequestParam(value="newid")Integer newid,
			                @RequestParam(value="currentPage")Integer currentPage,
			                Model model){
		
		model.addAttribute("mdfnew", newsService.findNew(newid));
		model.addAttribute("currentPage", currentPage);
		
		return "manager/news-modify.jsp";
	}
	
	
	/*
	 * ����news�޸�������Ϣ
	 */
	@RequestMapping(value="/upd")
	public String doUpdNews(News news,@RequestParam(value="currentPage")Integer currentPage){
		
		if(newsService.findUpd(news)>0){
			
		  return "redirect:/news/page?currentPage="+currentPage;
		}
		
		
		return "manager/error.jsp";
	}
	
	
	/*
	 * ����news�޸�������Ϣ
	 */
	@RequestMapping(value="/add")
	public String doddNews(News news,@RequestParam(value="currentPage")Integer currentPage){
		
		if(newsService.findAdd(news)>0){
			return "redirect:/news/page?currentPage="+currentPage;
		}
		
		return "manager/error.jsp";
	}
	
	
	

	
	
	
}
