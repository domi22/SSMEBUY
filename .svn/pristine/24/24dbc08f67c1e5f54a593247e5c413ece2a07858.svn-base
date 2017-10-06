package com.del.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.del.dao.T_statusMapper;

@Service("t_statusService")
public class T_statusServiceImpl implements T_statusService {

	@Autowired
	@Qualifier("t_statusMapper")
	private T_statusMapper  t_statusMapper;
	
	
	/*
	 * 根据indentID修改状态表的信息
	 */
	/* (non-Javadoc)
	 * @see com.del.service.T_statusService#findUpdT_status(java.lang.Integer, java.lang.String)
	 */
	@Override
	public int findUpdT_status(Integer indentid,String statusname){
		
		return t_statusMapper.getUpdStatus(indentid, statusname);
	}
	
	
	
	
	
}
