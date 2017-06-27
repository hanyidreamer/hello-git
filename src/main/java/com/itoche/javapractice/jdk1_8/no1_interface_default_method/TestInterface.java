package com.itoche.javapractice.jdk1_8.no1_interface_default_method;

/**
 * Created by ZHANGHANYI5 on 2017/6/27.
 *
 * 接口的默认方法
 */
public interface TestInterface
{
	public void testMethod(String word);

	default void testDefaultMethod(String word)
	{
		System.out.println("default interface method " + word);
	}
}

