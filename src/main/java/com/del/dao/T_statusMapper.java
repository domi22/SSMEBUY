package com.del.dao;

import org.apache.ibatis.annotations.Param;

public interface T_statusMapper {

	
	
	/*
	 * ����indentID�޸�״̬�����Ϣ
	 */
	public int getUpdStatus(@Param("indentid")Integer indentid,
			                @Param("statusname")String statusname);
}
