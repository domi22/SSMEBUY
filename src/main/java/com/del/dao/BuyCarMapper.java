package com.del.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.del.pojo.BuyCar;

public interface BuyCarMapper {

	
	
	/*
	 * 查询购物车列表
	 */
	public List<BuyCar> getBuyCarList(int userid);
	
	/*
	 * 根据用户编号和carid删除购物车记录
	 */
	public int getDelBuyCar(@Param("userid")int userid,
			                @Param("carid")int carid);

	
	/*
	 * 根据shangid和userid判断购物车是否存在该商品
	 */
	public BuyCar getHasBuyCar(@Param("userid")int userid,
			                @Param("shangid")int shangid);
	
	
	/*
	 * 根据shangid和userid给购物车商品数量加1
	 */
	public int getAddCount(@Param("userid")int userid,
			                @Param("shangid")int shangid);
	

	/*
	 * 插入一件商品到购物车
	 */
	public int getAddBuyCar(BuyCar buyCar);
	
	/*
	 * 根据userid删除购物车记录
	 */
	public int getDelBuyCar1(@Param("userid")int userid);
	
	/*
	 * 根据shangid删除购物车记录
	 */
	public int getDelBuyCar2(@Param("shangid")int shangid);
	
}
