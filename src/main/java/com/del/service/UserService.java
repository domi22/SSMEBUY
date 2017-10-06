package com.del.service;
import java.util.List;
import java.util.Map;

import com.del.pojo.Goods;
import com.del.pojo.User;


public interface UserService {

	
	 /*
	  * ��ѯ�û��б�
	  */
	public List<Goods> findGoods();
	
	 /*
	  *��֤�û���¼
	  */
	public User findLoginUser(String userName,String passWord);
	
	/*
	  *���ע���û�
	  */
	public int findRegister(User user);
	
	/*
	  *��֤�û����Ƿ����
	  */
	public int findHasName(String username);
	
	/*
	  *��ȡ���е��û�
	  */
	public List<User> findUserList();
	
	/*
	  *����useridɾ���û�
	  */
	public int findDelUser(int userid);
	
	/*
	  *�����޸��û�
	  */
	public int findUpdUser(User user);
	
	/*
	  *����Ա�����û�
	  */
	public int findAddUser(User user);
	
	/*
	  *����userID��ѯ�û�����Ϣ
	  */
	public User findUser(int userid);
	
	
	/*
	  *����goodidDɾ����Ʒ�����¼
	  */
	public int findDelGood(int goodid);
	
	/*
	  *����indentiD�޸��û������¼
	  */
	public int findUpdUser2(Map<String,Object> map);
	
	
	/*
	  *����goodidD��ѯ��Ʒ�����¼
	  */
	public Goods findOneGood(int goodid);
	
	
	/*
	 * ��ѯgoods�����goodid�޸���Ʒ��¼
	 */
	public int findMdfGood(Goods goods);
	
	
	
	/*
	 * <!--����good���������Ʒ������Ϣ-->
	 */
	public int findAddGood(Goods goods);
	
}
