package com.del.service;

import java.util.List;

import com.del.pojo.Notice;

public interface NoticeService {

	/*
	 * ��ȡ����7�������б�
	 */
	public abstract List<Notice> getNoticeList();
	
	/*
	 * ����noticeid��ѯ�����¼
	 */
	public abstract Notice findNotice(Integer noticeid);

}