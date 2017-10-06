package com.del.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.del.dao.BuyCarMapper;
import com.del.pojo.BuyCar;


@Service("buyCarService")
public class BuyCarServiceImpl implements BuyCarService {

@Autowired
@Qualifier("buyCarMapper")
private BuyCarMapper buyCarMapper;
	
	

	/*
	 * 根据用户id查询购物车列表
	 */
	@Override
	public List<BuyCar> findBuyCarList(int userid) {
		
		return buyCarMapper.getBuyCarList(userid);
	}



	/*
	 * 根据用户编号和carid删除购物车记录
	 */
	@Override
	public int findDelBuyCar(int userid, int carid) {
		
		return buyCarMapper.getDelBuyCar(userid, carid);
	}


	/*
	 * 根据shangid和userid判断购物车是否存在该商品
	 */
	@Override
	public BuyCar findHasBuyCar(int userid, int shangid) {
		
		return buyCarMapper.getHasBuyCar(userid, shangid);
	}



	/*
	 *插入一件商品到购物车
	*/
	@Override
	public int findAddBuyCar(BuyCar buyCar) {
		
		return buyCarMapper.getAddBuyCar(buyCar);
	}


	/*
	 *根据shangid和userid给购物车商品数量加1
	*/
	@Override
	public int findAddCount(int userid, int shangid) {
		
		return buyCarMapper.getAddCount(userid, shangid);
	}


	/*
	 * 根据用户编号删除购物车记录
	 */
	@Override
	public int findDelBuyCar1(int userid) {
		
		return buyCarMapper.getDelBuyCar1(userid);
	}



	
	/*
	 * 根据shangid删除购物车记录
	 */
	@Override
	public int findDelBuyCar2(int shangid) {
		
		return buyCarMapper.getDelBuyCar2(shangid);
	}

}
