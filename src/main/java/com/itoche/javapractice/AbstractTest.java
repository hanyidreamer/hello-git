package com.itoche.javapractice;

public abstract class AbstractTest extends TestInterfaceClass implements TestClass
{
	public void get()
	{
		System.out.println("11");
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
		System.out.println("22");
	}

	@Override
	public void get2()
	{
		System.out.println("33");
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
		System.out.println("44");
	}
}