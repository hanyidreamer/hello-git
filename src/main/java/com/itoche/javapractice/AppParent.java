package com.itoche.javapractice;

public class AppParent
{
	static String count = "父类static变量";

	static
	{
		System.out.println("父类static代码块");
	}

	{
		System.out.println("父类普通代码快");
	}

	String name = "父类普通变量";

	public AppParent()
	{
		System.out.println("父类构造方法");
	}

}
