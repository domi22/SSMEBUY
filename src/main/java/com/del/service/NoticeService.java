package com.del.service;

import java.util.List;

import com.del.pojo.Notice;

public interface NoticeService {

	/*
	 * 获取最新7条公告列表
	 */
	public abstract List<Notice> getNoticeList();
	
	/*
	 * 根据noticeid查询公告记录
	 */
	public abstract Notice findNotice(Integer noticeid);

}