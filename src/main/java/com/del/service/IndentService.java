package com.del.service;

import java.util.List;

import com.del.pojo.Indent;

public interface IndentService {

	/*
	 * ����useridɾ��������¼
	 */
	public abstract int findDelIndent(int userid);
	
	
	/*
	 * ����indentidɾ��������¼
	 */
	public abstract int findDelIndent2(int indentid);
	
	
	/*
	 * ��ѯ���ж�����¼
	 */
	public abstract int findCountIndent();
	
	/*
	 * ��ҳ��ѯ������¼
	 */
	public abstract List<Indent> findAllIndent(int usecurrentPage);
	
	/*
	 * ����indentid��username��ҳ��ѯ������¼
	 */
	public abstract List<Indent> findSomIndent(Integer usecurrentPage,Integer indentid,String username);

}