package com.del.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.del.dao.DetailsMapper;

@Service("detailsService")
public class DetailsServiceImpl implements DetailsService {

	@Autowired
	@Qualifier("detailsMapper")
	private DetailsMapper detailsMapper;
	
	
	/*
	 * 根据userid删除记录
	 */
	/* (non-Javadoc)
	 * @see com.del.service.DetailsService#findDelDetails(int)
	 */
	@Override
	public  int findDelDetails(int userid){
		
		return detailsMapper.getDelDetails(userid);
	}


	
	/*
	 * 根据shangid删除记录
	 */
	@Override
	public int findDelDetails2(int shangid) {
		// TODO Auto-generated method stub
		return detailsMapper.getDelDetails2(shangid);
	}



	
	
	/*
	 * 根据indentid删除记录
	 */
	@Override
	public int findDelDetails3(int indentid) {
		// TODO Auto-generated method stub
		return detailsMapper.getDelDetails3(indentid);
	}
	
}
