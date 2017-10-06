package com.del.tools;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 用于缓存的数据访问对象
 * @author Domi
 *
 */
public class RedisAPI {

	//jedis连接池对象
	public JedisPool jedisPool;

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

    /**
     * 缓存的设值
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
	 * 判断缓存中是否存在某个key值
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
			System.out.println("关闭成功===》");
			
		}
		return false;
	}
	
	/**
	 * 获得缓存中的key
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
	 * 返还jedisPool
	 * @param jedisPool
	 * @param jedis
	 */
	public static void returnResource(JedisPool jedisPool,Jedis jedis){
		if (jedis!=null) {
			jedisPool.returnResource(jedis);
		}
		
	}
	
	
}
