package com.del.dao;

import org.apache.ibatis.annotations.Param;

public interface DetailsMapper {

	
	/*
	 *  根据userid删除记录
	 *  
	 */
	public int getDelDetails(@Param("userid")int userid);
	
	
	/*
	 *  根据shangid删除记录
	 *  
	 */
	public int getDelDetails2(@Param("shangid")int shangid);
	
	
	/*
	 *  根据indentid删除记录
	 *  
	 */
	public int getDelDetails3(@Param("indentid")int indentid);
	
	
	
	
}
