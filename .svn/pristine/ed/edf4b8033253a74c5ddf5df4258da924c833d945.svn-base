package com.del.service;

import java.util.List;
import java.util.Map;

import com.del.pojo.Shangp;

public interface ShangpService {

	
	/*
	  * 获取主页的商品列表
	 */
	public abstract List<Shangp> getCenterShang();
	
	/*
	  * 获取商品页的列表
	 */
	public abstract List<Shangp> getProductShangp(Map<String,Object> pageMap);
	
	
	/*
	 * 
	 * 根据fatherid分页查询商品
	 */
	public abstract List<Shangp> findFatherShangp(Map<String,Object> pageMap);
	

	/*
	 * 
	 * 查询shangp总记录数
	 */
	public abstract int findAllShangp();
	
	
	
	
	/*
	 * 
	 * 根据goodid查询shangp总数
	 */
	public abstract int getShangpCount(int goodid);
	
	/*
	* 
	 *  根据fatherid查询商品的总记录数
	*/
	public abstract int findFatherCount(int fatherid);
	
	
	
	/*
	 * 
	 * 添加商品
	 */
	public abstract int findAddShangp(Shangp shangp);
	
	/*
	 * 
	 * 修改商品
	 */
	public abstract int findUpdShangp(Shangp shangp);
	
	
	
	/*
	 * 
	 * 根据shangid查询shang记录
	 */
	public abstract Shangp findOneShangp(int shangid);
	
	/*
	 * 
	 * 查询所有的商品
	 */
	public abstract List<Shangp> findShangp(int usecurrentPage);
	
	/*
	 * 
	 * 删除商品记录
	 */
	public abstract int findDelShangp(int shangid);
	
	/*
	 * 
	 * goodid删除商品记录
	 */
	public abstract int findDelgoodid(int goodid);
	
}

