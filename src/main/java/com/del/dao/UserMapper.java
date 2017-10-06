package com.del.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.del.pojo.Goods;
import com.del.pojo.User;

public interface UserMapper {

	/*
	 * ��ѯ���е���Ʒ
	 */
	public List<Goods> getAllGoods();
	
	/*
	 * ��¼��֤
	 */
	public User getLoginUser(@Param("userName")String userName,
			                 @Param("passWord")String passWord);
	
	/*
	 * ���ע���û�
	 */
	public int getRegister(User user);
	
	/*
	 * ��֤�û����Ƿ����
	 */
	public int getHasName(@Param("username")String username);
	
	/*
	 * ��ȡ�û��б�
	 */
	public List<User> getUserList();
	
	/*
	 * ����useridɾ���û�
	 */
	public int getDelUser(@Param("userid")int userid);
	
	/*
	 * ����Ա������û�
	 */
	public int getAddUser(User user);
	
	/*
	 * ����Ա�����û�
	 */
	public int getUpdUser(User user);
	
	/*
	 * ����userID��ѯ�û���Ϣ
	 */
	public User getUser(@Param("userid")int userid);
	
	
	/*
	 * ����indentID�޸��û���Ϣ
	 */
	public int getUpdUser2(Map<String,Object> map);
	
	
	
	/*
	 * ��ѯgoodidɾ����Ʒ��¼
	 */
	public int getDelGoods(int goodid);
	
	
	
	/*
	 * ��ѯgoodid��ѯ��Ʒ��¼
	 */
	public Goods getOneGood(int goodid);
	
	/*
	 * ��ѯgoods�����goodid�޸���Ʒ��¼
	 */
	public int getMdfGood(Goods goods);
	
	

	/*
	 * goods���������Ʒ����
	 */
	public int getAddGood(Goods goods);
	
	
	
	
}
