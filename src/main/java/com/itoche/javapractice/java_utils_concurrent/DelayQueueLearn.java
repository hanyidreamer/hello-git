package com.itoche.javapractice.java_utils_concurrent;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 延迟队列 DelayQueue
 *
 * DelayQueue 实现了 BlockingQueue 接口。
 * DelayQueue 对元素进行持有直到一个特定的延迟到期。注入其中的元素必须实现 java.util.concurrent.Delayed 接口。
 *
 * DelayQueue 将会在每个元素的 getDelay() 方法返回的值的时间段之后才释放掉该元素。如果返回的是 0 或者负值，延迟将被认为过期，该元素将会在 DelayQueue 的下一次 take  被调用的时候被释放掉。
 * 传递给 getDelay 方法的 getDelay 实例是一个枚举类型，它表明了将要延迟的时间段。TimeUnit 枚举将会取以下值：
 * DAYS
 * HOURS
 * MINUTES
 * SECONDS
 * MILLISECONDS
 * MICROSECONDS
 * NANOSECONDS
 *
 * 正如你所看到的，Delayed 接口也继承了 java.lang.Comparable 接口，这也就意味着 Delayed 对象之间可以进行对比。
 * 这个可能在对 DelayQueue 队列中的元素进行排序时有用，因此它们可以根据过期时间进行有序释放。
 */
public class DelayQueueLearn
{
	public static void main(String[] args)
	{
		try
		{
			DelayQueue queue = new DelayQueue();

			Delayed element1 = new DelayedElement();

			queue.put(element1);

			Delayed element2 = queue.take();

			System.out.println(element2);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}

class DelayedElement implements Delayed
{
	@Override
	public long getDelay(TimeUnit unit)
	{
		return 3;
	}

	@Override
	public int compareTo(Delayed o)
	{
		return 0;
	}
}
