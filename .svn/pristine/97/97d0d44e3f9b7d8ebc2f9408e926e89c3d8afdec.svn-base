package com.del.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.del.pojo.News;

public interface NewsService {

	/*
	 * 获取最新新闻列表
	 */
	public abstract List<News> getNewsList();
	
	/*
	 * 获取新闻列表总记录数
	 */
	public abstract int findCountList();
	
	/*
	 * 根据newid查询New记录
	 */
	public abstract News findNew(Integer newid);
	
	/*
	 * 根据newid修改新闻记录
	 */
	public abstract int findUpd(News news);
	
	/*
	 * 添加新闻记录
	 */
	public abstract int findAdd(News news);
	
	
	
	
	/*
	 * 分页显示新闻
	 */
	public abstract List<News> getPageNews(Integer currentPage);
	
	/*
	 * 根据newid删除新闻记录
	 */
	public abstract int  findDel(Integer newid);
	

}