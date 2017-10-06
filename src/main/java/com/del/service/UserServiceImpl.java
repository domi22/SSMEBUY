package com.del.service;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.del.dao.UserMapper;
import com.del.pojo.Goods;
import com.del.pojo.User;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;
	
	/* 
	 * 查询左侧导航列表
	 * @see com.del.service.ShangpService#findGoods()
	 */
	@Override
	public List<Goods> findGoods() {
		
		return userMapper.getAllGoods();
	}
	
	
	/*
	  *验证用户登录
	  */
	@Override
	public User findLoginUser(String userName, String passWord) {
		
		return userMapper.getLoginUser(userName, passWord);
	}

	
	/*
	  *添加注册用户
	  */
	@Override
	public int findRegister(User user) {
		
		return userMapper.getRegister(user);
	}


	/*
	  *验证用户名是否可用
	  */
	@Override
	public int findHasName(String username) {
	
		return userMapper.getHasName(username);
	}

	
	/*
	  *获取所有的用户
	  */
	@Override
	public List<User> findUserList() {
		
		return userMapper.getUserList();
	}

	
	/*
	  *根据userid删除用户
	  */
	@Override
	public int findDelUser(int userid) {

		return userMapper.getDelUser(userid);
	}


	
	/*
	  *管理员新增用户
	  */
	@Override
	public int findAddUser(User user) {
		
		return userMapper.getAddUser(user);
	}


	
	/*
	  *根据userID查询用户的信息
	  */
	@Override
	public User findUser(int userid) {
		
		return userMapper.getUser(userid);
	}


	
	
	/*
	 * 管理员更改用户
	 */
	@Override
	public int findUpdUser(User user) {
		
		return userMapper.getUpdUser(user);
	}


	
	/*
	  *根据goodidD删除商品分类记录
	  */
	@Override
	public int findDelGood(int goodid) {
	
		return userMapper.getDelGoods(goodid);
	}


	
	/*
	  *根据goodidD查询商品分类记录
	  */
	@Override
	public Goods findOneGood(int goodid) {
		// TODO Auto-generated method stub
		return userMapper.getOneGood(goodid);
	}


	
	
	/*
	 * 查询goods对象的goodid修改商品记录
	 */
	@Override
	public int findMdfGood(Goods goods) {
		// TODO Auto-generated method stub
		return userMapper.getMdfGood(goods);
	}


	
	/*
	 * -根据good对象添加商品分类信息-->
	 */
	@Override
	public int findAddGood(Goods goods) {
		// TODO Auto-generated method stub
		return userMapper.getAddGood(goods);
	}


	
	/*
	  *根据indentiD修改用户分类记录
	  */
	@Override
	public int findUpdUser2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userMapper.getUpdUser2(map);
	}

}
