package com.del.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.del.pojo.Shangp;

public interface ShangpMapper {

	/*
	 * 
	 * 查询首页展示的8件商品
	 */
	public List<Shangp> getShangp8();
	
	
	/*
	 * 
	 * 查询商品总记录数
	 */
	public int getAllShangp();
	
	      
	
	/*
	 * 
	 * 分页查询所有的商品
	 */
	public List<Shangp> getShangp(@Param("usecurrentPage")int usecurrentPage);
	
	
	/*
	 * 
	 * 根据goodid查询指定页shangpList
	 */
	public List<Shangp> getProductShangp(Map<String,Object> pageMap);
	
	/*
	 * 
	 * 根据fatherid分页查询商品
	 */
	public List<Shangp> getFatherShangp(Map<String,Object> pageMap);
	
	/*
	 * 
	 * 根据goodid查询shangp总数
	 */
	public int getShangpCount(int goodid);
	
	
    /*
	* 
	 *  根据fatherid查询商品的总记录数
	*/
	public int getfatherCount(int fatherid);
	
	/*
	 * 
	 * 根据shangid查询单件商品信息 
	 */
	public Shangp getOneShangp(int shangid);
	
	/*
	 * 
	 * 新增1件商品信息 
	 */
	public int getAddShangp(Shangp shangp);
	
	/*
	 * 
	 * 修改商品的信息 
	 */
	public int getUpdShangp(Shangp shangp);
	
	
	/*
	 * 
	 * shangid删除商品的信息 
	 */
	public int getDelShangp(int shangid);
	
	/*
	 * 
	 * goodid删除商品的信息 
	 */
	public int getDelgoodid(int goodid);
	
	
	
}
