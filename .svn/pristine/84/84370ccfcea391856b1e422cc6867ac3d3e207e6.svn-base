package com.del.service;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.del.dao.ShangpMapper;
import com.del.pojo.Shangp;

@Service("shangpService")
public class ShangpServiceImpl implements ShangpService {
	
	 @Autowired 
	 @Qualifier("shangpMapper")
	 private ShangpMapper shangpMapper;
	 
	 /*
	  * 获取主页的商品列表
	  *  (non-Javadoc)
	 * @see com.del.service.ShangpService#getCenterShang()
	 */
	@Override
	public List<Shangp> getCenterShang(){
		  
		 return shangpMapper.getShangp8();
	 }

	/*
	  * 获取指定goodid的商品列表
	 */
	@Override
	public List<Shangp> getProductShangp(Map<String,Object> pageMap) {
		
		return shangpMapper.getProductShangp(pageMap);
	}

	
	/*
	 * 
	 * 根据goodid查询shangp总数
	 */
	@Override
	public int getShangpCount(int goodid) {
		
		return shangpMapper.getShangpCount(goodid);
	}

	
	
	/*
	 * 
	 * 根据shangid查询shang记录
	 */
	@Override
	public Shangp findOneShangp(int shangid) {
		
		return shangpMapper.getOneShangp(shangid);
	}

	
	/*
	 * 
	 * 查询所有的商品
	 */
	@Override
	public List<Shangp> findShangp(int usecurrentPage) {

		return shangpMapper.getShangp(usecurrentPage);
	}

	
	
	

	/*
	 * 
	 * 查询shangp总记录数
	 */
	@Override
	public int findAllShangp() {

		return shangpMapper.getAllShangp();
	}

	
	/*
	 * 
	 * 添加商品
	 */
	@Override
	public int findAddShangp(Shangp shangp) {

		return shangpMapper.getAddShangp(shangp);
	}

	
	
	/*
	 * 
	 * 修改商品
	 */
	@Override
	public int findUpdShangp(Shangp shangp) {
		
		return shangpMapper.getUpdShangp(shangp);
	}

	
	
	
	/*
	 * 
	 * 删除商品记录
	 */
	@Override
	public int findDelShangp(int shangid) {
		
		return shangpMapper.getDelShangp(shangid);
	}

	
	
	/*
	 * 
	 * goodid删除商品记录
	 */
	@Override
	public int findDelgoodid(int goodid) {
		// TODO Auto-generated method stub
		return shangpMapper.getDelgoodid(goodid);
	}

	
	
	
	/*
	 * 
	 * 根据fatherid分页查询商品
	 */
	@Override
	public List<Shangp> findFatherShangp(Map<String, Object> pageMap) {
		// TODO Auto-generated method stub
		return shangpMapper.getFatherShangp(pageMap);
	}

	
	
	/*
	* 
	 *  根据fatherid查询商品的总记录数
	*/
	@Override
	public int findFatherCount(int fatherid) {
		// TODO Auto-generated method stub
		return shangpMapper.getfatherCount(fatherid);
	}
	
	
	
	
	
}
