package com.del.tools;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testJedis() {
		ClassPathXmlApplicationContext xt = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
		System.out.println("jedisPool======="+xt.getBean("jedisPool"));
		System.out.println("jedisPoolConfig==========="+xt.getBean("jedisPoolConfig"));
		
		System.out.println("redisAPI==========="+xt.getBean("redisAPI"));
	
	}
	
	@Test
	public void testJdeisPool(){
//		JedisPool pool = new JedisPool("127.0.0.1",6379);
//		System.out.println("pool"+pool);
//		pool.close();
		Jedis jedis = new Jedis("127.0.0.1",6379);
		//jedis.set("132", "1111");
		System.out.println(jedis.get("112"));
	}

}
