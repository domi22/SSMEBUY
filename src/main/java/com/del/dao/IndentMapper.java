package com.del.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.del.pojo.Indent;

public interface IndentMapper {

	
	
	/*
	 * ����useridɾ��������¼
	 */
	public int getDelIndent(int userid);
	
	/*
	 * ����indentidɾ��������¼
	 */
	public int getDelIndent2(int indentid);
	
	/*
	 * ��ѯ�ܵĶ�����¼
	 */
	public int getCountIndent();
	
	
	
	/*
	 * ��ҳ��ʾ������¼
	 */
	public List<Indent> getAllIndent(@Param("usecurrentPage")int usecurrentPage);
	
	/*
	 * ����indentid��username��ҳ��ѯ������¼
	 */
	public List<Indent> getSomIndent(@Param("usecurrentPage")Integer usecurrentPage,
			                         @Param("indentid")Integer indentid,
			                         @Param("username")String username);
	
}
