package com.del.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.del.pojo.Goods;
import com.del.pojo.User;

public interface UserMapper {

	/*
	 * 查询所有的商品
	 */
	public List<Goods> getAllGoods();
	
	/*
	 * 登录验证
	 */
	public User getLoginUser(@Param("userName")String userName,
			                 @Param("passWord")String passWord);
	
	/*
	 * 添加注册用户
	 */
	public int getRegister(User user);
	
	/*
	 * 验证用户名是否可用
	 */
	public int getHasName(@Param("username")String username);
	
	/*
	 * 获取用户列表
	 */
	public List<User> getUserList();
	
	/*
	 * 根据userid删除用户
	 */
	public int getDelUser(@Param("userid")int userid);
	
	/*
	 * 管理员添加新用户
	 */
	public int getAddUser(User user);
	
	/*
	 * 管理员更改用户
	 */
	public int getUpdUser(User user);
	
	/*
	 * 根据userID查询用户信息
	 */
	public User getUser(@Param("userid")int userid);
	
	
	/*
	 * 根据indentID修改用户信息
	 */
	public int getUpdUser2(Map<String,Object> map);
	
	
	
	/*
	 * 查询goodid删除商品记录
	 */
	public int getDelGoods(int goodid);
	
	
	
	/*
	 * 查询goodid查询商品记录
	 */
	public Goods getOneGood(int goodid);
	
	/*
	 * 查询goods对象的goodid修改商品记录
	 */
	public int getMdfGood(Goods goods);
	
	

	/*
	 * goods对象添加商品分类
	 */
	public int getAddGood(Goods goods);
	
	
	
	
}
