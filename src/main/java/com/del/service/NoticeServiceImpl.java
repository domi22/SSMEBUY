package com.del.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.del.dao.NoticeMapper;
import com.del.pojo.Notice;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    
	@Autowired
    @Qualifier("noticeMapper")
	private NoticeMapper noticeMapper;
	
	/*
	 * ��ȡ����7�������б�
	 */
	/* (non-Javadoc)
	 * @see com.del.service.NoticeService#getNoticeList()
	 */
	@Override
	public List<Notice> getNoticeList(){
		
		List<Notice> list = noticeMapper.findAllNoticeList();
		return list;
	}

	
	
	/*
	 * ����noticeid��ѯ�����¼
	 */
	@Override
	public Notice findNotice(Integer noticeid) {
		// TODO Auto-generated method stub
		return noticeMapper.getNotice(noticeid);
	}
}
