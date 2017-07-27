package com.itoche.javapractice.java_utils_concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列 BlockingQueue
 *
 * 一个线程往里边放，另外一个线程从里边取的一个 BlockingQueue。
 * 一个线程将会持续生产新对象并将其插入到队列之中，直到队列达到它所能容纳的临界点。也就是说，它是有限的。
 * 如果该阻塞队列到达了其临界点，负责生产的线程将会在往里边插入新对象时发生阻塞。它会一直处于阻塞之中，直到负责消费的线程从队列中拿走一个对象。
 * 负责消费的线程将会一直从该阻塞队列中拿出对象。如果消费线程尝试去从一个空的队列中提取对象的话，这个消费线程将会处于阻塞之中，直到一个生产线程把一个对象丢进队列。
 *
 *      抛异常	     特定值	     阻塞	    超时
 * 插入	add(o)	    offer(o)	put(o)	offer(o, timeout, timeunit)
 * 移除	remove(o)	poll(o)	   take(o)	poll(timeout, timeunit)
 * 检查	element(o)	peek(o)
 *
 * 四组不同的行为方式解释：
 * 抛异常：如果试图的操作无法立即执行，抛一个异常。
 * 特定值：如果试图的操作无法立即执行，返回一个特定的值(常常是 true / false)。
 * 阻塞：如果试图的操作无法立即执行，该方法调用将会发生阻塞，直到能够执行。
 * 超时：如果试图的操作无法立即执行，该方法调用将会发生阻塞，直到能够执行，但等待时间不会超过给定值。返回一个特定值以告知该操作是否成功(典型的是 true / false)。
 *
 * 无法向一个 BlockingQueue 中插入 null。如果你试图插入 null，BlockingQueue 将会抛出一个 NullPointerException。
 * 可以访问到 BlockingQueue 中的所有元素，而不仅仅是开始和结束的元素。比如说，你将一个对象放入队列之中以等待处理，但你的应用想要将其取消掉。那么你可以调用诸如 remove(o) 方法来将队列之中的特定对象进行移除。但是这么干效率并不高(译者注：基于队列的数据结构，获取除开始或结束位置的其他对象的效率不会太高)，因此你尽量不要用这一类的方法，除非你确实不得不那么做。
 *
 * BlockingQueue 的实现：
 * ArrayBlockingQueue
 * DelayQueue
 * LinkedBlockingQueue
 * PriorityBlockingQueue
 * SynchronousQueue
 *
 */
public class BlockingQueueLearn
{
	public static void main(String[] args) throws Exception
	{
		BlockingQueue queue = new ArrayBlockingQueue(1024);

		Producer producer = new Producer(queue);
		Producer producer1 = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		new Thread(producer).start();
		new Thread(producer1).start();
		new Thread(consumer).start();

		Thread.sleep(4000);
	}
}
class Producer implements Runnable
{
	protected BlockingQueue queue = null;

	public Producer(BlockingQueue queue)
	{
		this.queue = queue;
	}

	public void run()
	{
		try
		{
			queue.put("1");
			Thread.sleep(1000);
			queue.put("2");
			Thread.sleep(1000);
			queue.put("3");
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
class Consumer implements Runnable
{
	protected BlockingQueue queue = null;

	public Consumer(BlockingQueue queue)
	{
		this.queue = queue;
	}

	public void run()
	{
		try
		{
			while (true)
			{
				System.out.println(Thread.currentThread().getId() + ":" + queue.take());
			}
			//			System.out.println(Thread.currentThread().getId() + ":" + queue.take());
			//			System.out.println(Thread.currentThread().getId() + ":" + queue.take());
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}