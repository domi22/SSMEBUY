package com.del.service;
import java.util.List;
import java.util.Map;

import com.del.pojo.Goods;
import com.del.pojo.User;


public interface UserService {

	
	 /*
	  * 查询用户列表
	  */
	public List<Goods> findGoods();
	
	 /*
	  *验证用户登录
	  */
	public User findLoginUser(String userName,String passWord);
	
	/*
	  *添加注册用户
	  */
	public int findRegister(User user);
	
	/*
	  *验证用户名是否可用
	  */
	public int findHasName(String username);
	
	/*
	  *获取所有的用户
	  */
	public List<User> findUserList();
	
	/*
	  *根据userid删除用户
	  */
	public int findDelUser(int userid);
	
	/*
	  *管理修改用户
	  */
	public int findUpdUser(User user);
	
	/*
	  *管理员新增用户
	  */
	public int findAddUser(User user);
	
	/*
	  *根据userID查询用户的信息
	  */
	public User findUser(int userid);
	
	
	/*
	  *根据goodidD删除商品分类记录
	  */
	public int findDelGood(int goodid);
	
	/*
	  *根据indentiD修改用户分类记录
	  */
	public int findUpdUser2(Map<String,Object> map);
	
	
	/*
	  *根据goodidD查询商品分类记录
	  */
	public Goods findOneGood(int goodid);
	
	
	/*
	 * 查询goods对象的goodid修改商品记录
	 */
	public int findMdfGood(Goods goods);
	
	
	
	/*
	 * <!--根据good对象添加商品分类信息-->
	 */
	public int findAddGood(Goods goods);
	
}
