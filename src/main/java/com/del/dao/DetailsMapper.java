package com.del.dao;

import org.apache.ibatis.annotations.Param;

public interface DetailsMapper {

	
	/*
	 *  ����useridɾ����¼
	 *  
	 */
	public int getDelDetails(@Param("userid")int userid);
	
	
	/*
	 *  ����shangidɾ����¼
	 *  
	 */
	public int getDelDetails2(@Param("shangid")int shangid);
	
	
	/*
	 *  ����indentidɾ����¼
	 *  
	 */
	public int getDelDetails3(@Param("indentid")int indentid);
	
	
	
	
}
