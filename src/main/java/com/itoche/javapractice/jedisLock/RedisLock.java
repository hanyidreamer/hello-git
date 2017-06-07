package com.itoche.javapractice.jedisLock;

import redis.clients.jedis.Jedis;

/**
 * Created by ZHANGHANYI5 on 2017/6/7.
 */
public class RedisLock
{
	private int timeoutMsecs = 6000;    //  锁等待超时，防止线程饥饿，永远没有入锁执行代码的机会
	private long expireMsecs = 3000;    // 锁持有超时，防止线程在入锁以后，无限的执行下去，让锁无法释放
	private String lockKey = "redisLock";        // redis 锁key
	private boolean locked = false;        // 是否获得锁

	/**
	 * Acquire lock.
	 *
	 * @param jedis
	 * @return true if lock is acquired, false acquire timeouted
	 * @throws InterruptedException
	 *             in case of thread interruption
	 */
	public synchronized boolean acquire(Jedis jedis) throws InterruptedException
	{
		System.out.println(Thread.currentThread().getId() + "_进入执行获取redis锁!当前时间：" + System.currentTimeMillis());
		int timeout = timeoutMsecs;
		while (timeout >= 0)
		{
			long expires = System.currentTimeMillis() + expireMsecs + 1;
			String expiresStr = String.valueOf(expires); //锁到期时间

			if (jedis.setnx(lockKey, expiresStr) == 1)
			{
				System.out.println(Thread.currentThread().getId() + "_获取reids锁成功，锁到期时间：" + expiresStr + ",当前时间：" + System.currentTimeMillis() + ",timeout:" + timeout);
				// lock acquired
				locked = true;
				return true;
			}

			String currentValueStr = jedis.get(lockKey); //redis里的时间
			if (currentValueStr != null && Long.parseLong(currentValueStr) < System.currentTimeMillis())
			{
				//判断是否为空，不为空的情况下，如果被其他线程设置了值，则第二个条件判断是过不去的
				// lock is expired

				String oldValueStr = jedis.getSet(lockKey, expiresStr);
				//获取上一个锁到期时间，并设置现在的锁到期时间，
				//只有一个线程才能获取上一个线上的设置时间，因为jedis.getSet是同步的
				if (oldValueStr != null && oldValueStr.equals(currentValueStr))
				{
					//如过这个时候，多个线程恰好都到了这里，但是只有一个线程的设置值和当前值相同，他才有权利获取锁
					// lock acquired
					System.out.println(Thread.currentThread().getId() + "_获取reids锁成功，锁到期时间：" + expiresStr + ",当前时间：" + System.currentTimeMillis() + ",timeout:" + timeout);
					locked = true;
					return true;
				}
			}
			timeout -= 100;
			Thread.sleep(100);
		}
		System.out.println(Thread.currentThread().getId() + "_线程尝试获取redis锁失败!");
		return false;
	}

	public synchronized boolean release(Jedis jedis)
	{
		try
		{
			System.out.println(Thread.currentThread().getId() + "_进入释放锁，locked：" + locked);
			if (locked)
			{
				jedis.del(lockKey);
				locked = false;
			}
		}
		catch (Exception e)
		{
			System.out.println("释放锁错误!");
			return false;
		}

		return true;
	}
}
