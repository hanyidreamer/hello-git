package com.itoche.javapractice.jedisLock;

import redis.clients.jedis.Jedis;

/**
 * Created by ZHANGHANYI5 on 2017/6/7.
 */
public class RedisTest1
{
	private Jedis jedis;

	/**
	 * 连接redis服务器
	 */
	public void connectRedis()
	{
		// 连接redis服务器
		jedis = RedisUtil.getJedis();
	}

	// redis-server redis.windows.conf
	public static void main(String[] args)
	{
		for (int i = 0; i < 100; i++)
		{
			new Thread()
			{
				@Override
				public void run()
				{
					RedisLock jedisLock = new RedisLock();

					RedisTest1 test = new RedisTest1();
					test.connectRedis();
					Jedis jedis1 = test.jedis;

					try
					{
						if (jedisLock.acquire(jedis1))
						{
							Thread.sleep(2000);
						}
					}
					catch (InterruptedException e)
					{
						System.out.println("分布式锁异常");
						e.printStackTrace();
					}
					finally
					{
						jedisLock.release(jedis1);
						if (jedis1 != null)
						{
							try
							{
								RedisUtil.returnResource(jedis1);// 还到连接池里
							}
							catch (Exception e)
							{
							}
						}
					}
				}
			}.start();
		}
	}
}
