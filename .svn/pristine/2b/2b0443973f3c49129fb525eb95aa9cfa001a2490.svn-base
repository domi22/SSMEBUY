package com.del.service;
import java.util.List;
import com.del.pojo.BuyCar;

public interface BuyCarService {

	
	/*
	 * 根据用户id查询购物车列表
	 */
	public List<BuyCar> findBuyCarList(int userid);
	
	
	/*
	 * 根据用户编号和carid删除购物车记录
	 */
	public int findDelBuyCar(int userid,int carid);
	
	
	/*
	 * 根据用户编号删除购物车记录
	 */
	public int findDelBuyCar1(int userid);
	
	/*
	 * 根据shangid删除购物车记录
	 */
	public int findDelBuyCar2(int shangid);
	
	
	
	/*
	 * 根据shangid和userid判断购物车是否存在该商品
	 */
	public BuyCar findHasBuyCar(int userid,int shangid);
	
	/*
	 *根据shangid和userid给购物车商品数量加1
	*/
	public int findAddCount(int userid,int shangid);
	
	
	/*
	 *插入一件商品到购物车
	*/
	public int findAddBuyCar(BuyCar buyCar);
}
