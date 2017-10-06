package com.del.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.del.dao.LiuyanMapper;
import com.del.pojo.Liuyan;

@Service("liuyanService")
public class LiuyanServiceImpl implements LiuyanService {
   
	
	@Autowired
    @Qualifier("liuyanMapper")
	private LiuyanMapper liuyanMapper;
 

	/*
	 * 查询所有的留言记录
	 */
	/* (non-Javadoc)
	 * @see com.del.service.LiuyanService#getAllLiuyan()
	 */
	@Override
	public  List<Liuyan> findAllLiuyan(Integer currentPage){
		
		return liuyanMapper.getAllLiuyan(currentPage);
	}


	
	/*
	 * 查询留言总记录数
	 */
	@Override
	public int findCountLiuyan() {
		// TODO Auto-generated method stub
		return liuyanMapper.getCountLiuyan();
	}



	
	/*
	 * 用lyid删除记录
	 */
	@Override
	public int findDelLiuyan(Integer lyid) {

		return liuyanMapper.getDelLiuyan(lyid);
	}



	
	/*
	 *  前台展示最近的3条留言
	 */
	@Override
	public ArrayList<Liuyan> findWebLiuyan(Integer currentPage) {
		
		return liuyanMapper.getWebLiuyan(currentPage);
	}


	
	/*
	 * 添加留言记录
	 */
	@Override
	public int findAddLiuyan(Liuyan liuyan) {
		// TODO Auto-generated method stub
		return liuyanMapper.getAddLiuyan(liuyan);
	}
	
}
