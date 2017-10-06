package com.del.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.del.dao.IndentMapper;
import com.del.pojo.Indent;

@Service("indentService")
public class IndentServiceImpl implements IndentService {

	@Autowired
	@Qualifier("indentMapper")
	private IndentMapper indentMapper;
	
	
	/*
	 * 根据userid删除订单记录
	 */
	/* (non-Javadoc)
	 * @see com.del.service.IndentService#findDelIndent(int)
	 */
	@Override
	public int findDelIndent(int userid){
		
	   return indentMapper.getDelIndent(userid);	
	}


	
	/*
	 * 分页查询订单记录
	 */
	@Override
	public List<Indent> findAllIndent(int usecurrentPage) {
		// TODO Auto-generated method stub
		return indentMapper.getAllIndent(usecurrentPage);
	}



	
	/*
	 * 查询所有订单记录
	 */
	@Override
	public int findCountIndent() {
		// TODO Auto-generated method stub
		return indentMapper.getCountIndent();
	}



	
	/*
	 * 根据indentid、username分页查询订单记录
	 */
	@Override
	public List<Indent> findSomIndent(Integer usecurrentPage, Integer indentid,
			String username) {
		// TODO Auto-generated method stub
		return indentMapper.getSomIndent(usecurrentPage, indentid, username);
	}



	
	/*
	 * 根据indentid删除订单记录
	 */
	@Override
	public int findDelIndent2(int indentid) {
		// TODO Auto-generated method stub
		return indentMapper.getDelIndent2(indentid);
	}
}
