package com.del.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.del.dao.NewsMapper;
import com.del.pojo.News;

@Service("newsService")
public class NewsServiceImpl implements NewsService {
    
	@Autowired
	@Qualifier("newsMapper")
	private NewsMapper newsMapper;
	/*
	 * 获取最新新闻列表
	 */
	/* (non-Javadoc)
	 * @see com.del.service.NewsService#getNewsList()
	 */
	@Override
	public List<News> getNewsList(){
		
		return newsMapper.getAllNews();
		
	}
	
	
	
	
	/*
	 * 分页显示新闻
	 */
	@Override
	public List<News> getPageNews(Integer currentPage) {
		// TODO Auto-generated method stub
		return newsMapper.getPageNews(currentPage);
	}



	/*
	 * 获取新闻列表总记录数
	 */
	@Override
	public int findCountList() {
		// TODO Auto-generated method stub
		return newsMapper.getCountNews();
	}



	/*
	 * 根据newid查询New记录
	 */
	@Override
	public News findNew(Integer newid) {
		// TODO Auto-generated method stub
		return newsMapper.getNew(newid);
	}




	/*
	 * 根据newid删除新闻记录
	 */
	@Override
	public int findDel(Integer newid) {

		return newsMapper.getDel(newid);
	}




	/*
	 * 根据newid修改新闻记录
	 */
	@Override
	public int findUpd(News news) {
		// TODO Auto-generated method stub
		return newsMapper.getUpd(news);
	}




	
	/*
	 * 添加新闻记录
	 */
	@Override
	public int findAdd(News news) {
		// TODO Auto-generated method stub
		return newsMapper.getAdd(news);
	}
}
