package com.itoche.javapractice;

/**
 * @description:测试Abstract类
 * @projectName: javapractice
 * @className: AbstractTest.java
 * @author: hy.zhang
 * @createTime: 2017年4月16日 下午8:33:20
 * @version 1.0
 */
public abstract class AbstractTest extends TestInterfaceClass implements TestClass
{
	public void get()
	{
		System.out.println("Abstract类自己普通方法");
	}

	public abstract void get1();

	public static void main(String[] args)
	{
		AbstractTest abstractTest = new AbstractImpl();
		abstractTest.get();
		abstractTest.get1();
		abstractTest.get2();
		abstractTest.get3();
	}
}

class AbstractImpl extends AbstractTest
{
	@Override
	public void get1()
	{
		System.out.println("AbstractImpl类继承Abstract类继承方法实现");
	}

	@Override
	public void get2()
	{
		System.out.println("AbstractImpl类继承Abstract类实现的接口TestClass继承方法实现");
	}
}

interface TestClass
{
	public abstract void get2();
}

class TestInterfaceClass
{
	public void get3()
	{
		System.out.println("AbstractImpl父类TestInterfaceClass方法");
	}
}