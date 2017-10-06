package com.del.service;

public interface T_statusService {

	/*
	 * 根据indentID修改状态表的信息
	 */
	public abstract int findUpdT_status(Integer indentid, String statusname);

}