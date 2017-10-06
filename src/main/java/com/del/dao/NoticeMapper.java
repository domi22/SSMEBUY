package com.del.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.del.pojo.News;
import com.del.pojo.Notice;

public interface NoticeMapper {
	/*
	 * 获取最新公告列表
	 */
	public List<Notice> findAllNoticeList();
	
	/*
	 * 根据noticeid查询公告记录
	 */
	public Notice  getNotice(@Param("noticeid")Integer noticeid);
	
}
