package com.del.dao;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.del.pojo.Liuyan;

public interface LiuyanMapper {

	
	
	
	/*
	 * 查询所有的留言列表
	 */
	public List<Liuyan> getAllLiuyan(@Param("currentPage")Integer currentPage);
	
	
	/*
	 * 添加留言信息
	 */
	public int getAddLiuyan(Liuyan liuyan);
	
	
	
	/*
	 * 查询留言的总记录数
	 */
	public int getCountLiuyan();
	
	/*
	 * 根据lyID删除留言记录
	 */
	public int getDelLiuyan(@Param("lyid")Integer lyid);
	
	
	/*
	 *  前台展示最近的3条留言
	 */
	public ArrayList<Liuyan> getWebLiuyan(@Param("currentPage")Integer currentPage);
	
	
}
