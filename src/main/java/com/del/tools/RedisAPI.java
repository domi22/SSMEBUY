package com.del.tools;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * ���ڻ�������ݷ��ʶ���
 * @author Domi
 *
 */
public class RedisAPI {

	//jedis���ӳض���
	public JedisPool jedisPool;

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

    /**
     * �������ֵ
     */
	public boolean set(String key,String value){
		Jedis jedis = null;
		
		try {
			
			jedis = jedisPool.getResource();
			
			jedis.set(key,value);
			return true;
		} catch (Exception e) {
			// TODO: handle exceptionr
			e.printStackTrace();
			
		}finally{
			returnResource(jedisPool, jedis);
			
		}
		
		return false;
	}
	
	
	
	/**
	 * �жϻ������Ƿ����ĳ��keyֵ
	 */
	public boolean exist(String key){
		Jedis jedis =null;
		try {
			jedis = jedisPool.getResource();
			return jedis.exists(key);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			returnResource(jedisPool, jedis);
			System.out.println("�رճɹ�===��");
			
		}
		return false;
	}
	
	/**
	 * ��û����е�key
	 */
	
	public String get(String key){
		String value = null;
		Jedis jedis =null;
		try {
			jedis = jedisPool.getResource();	
			value = jedis.get(key);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			returnResource(jedisPool, jedis);
			
		}
		
		return value; 
	}
	
	/**
	 * ����jedisPool
	 * @param jedisPool
	 * @param jedis
	 */
	public static void returnResource(JedisPool jedisPool,Jedis jedis){
		if (jedis!=null) {
			jedisPool.returnResource(jedis);
		}
		
	}
	
	
}
