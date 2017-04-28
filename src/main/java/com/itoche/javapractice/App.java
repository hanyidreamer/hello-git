package com.itoche.javapractice;

/**
 * @description:
 * @author: zhanghanyi5
 * @createTime: 2017/4/25 11:18
 */
public class App extends AppParent
{
	static String count1 = "子类static变量 ";

	static
	{
		System.out.println("子类static代码块");
	}

	public App()
	{
		System.out.println("子类构造方法");
	}

	{
		System.out.println("子类普通代码快");
	}

	String name1 = "子类普通成员变量";

	/**
	 * @description:
	 * @param
	 * @return
	 * @author: zhanghanyi5
	 * @createTime: 2017/4/25 11:42
	 */
	public static void main(String[] args)
	{
		System.out.println(App.count1);
		System.out.println("==============");
		App app = new App();
	}
}
