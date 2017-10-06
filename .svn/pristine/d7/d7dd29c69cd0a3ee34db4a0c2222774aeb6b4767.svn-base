package com.del.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.del.pojo.Indent;

public interface IndentMapper {

	
	
	/*
	 * 根据userid删除订单记录
	 */
	public int getDelIndent(int userid);
	
	/*
	 * 根据indentid删除订单记录
	 */
	public int getDelIndent2(int indentid);
	
	/*
	 * 查询总的订单记录
	 */
	public int getCountIndent();
	
	
	
	/*
	 * 分页显示订单记录
	 */
	public List<Indent> getAllIndent(@Param("usecurrentPage")int usecurrentPage);
	
	/*
	 * 根据indentid、username分页查询订单记录
	 */
	public List<Indent> getSomIndent(@Param("usecurrentPage")Integer usecurrentPage,
			                         @Param("indentid")Integer indentid,
			                         @Param("username")String username);
	
}
