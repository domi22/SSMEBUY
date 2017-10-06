package com.del.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.del.pojo.News;

public interface NewsMapper {

	
	/*
	 * 获取最新新闻的列表
	 */
	public List<News> getAllNews();
	
	/*
	 * 获取最新新闻的总记录数
	 */
	public int getCountNews();
	
	/*
	 * 根据newid查询新闻记录
	 */
	public News  getNew(@Param("newid")Integer newid);
	
	/*
	 * 根据newid删除新闻记录
	 */
	public int  getDel(@Param("newid")Integer newid);
	
	
	/*
	 * 根据newid修改新闻记录
	 */
	public int  getUpd(News news);
	
	/*
	 * 根据new对象添加新闻记录
	 */
	public int  getAdd(News news);
	
	/*
	 * 分页显示新闻列表
	 */
	public List<News> getPageNews(Integer currentPage);
	
	
}
