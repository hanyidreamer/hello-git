package com.itoche.javapractice.jdk1_8.no8_the_default_method_for_accessing_interfaces;

/**
 * Created by ZHANGHANYI5 on 2017/6/27.
 *
 * 访问接口的默认方法
 */
public class Test
{
	public static void main(String[] args)
	{
		// 还记得第一节中的formula例子么，接口Formula定义了一个默认方法sqrt可以直接被formula的实例包括匿名对象访问到，
		// 但是在lambda表达式中这个是不行的。 Lambda表达式中是无法访问到默认方法的
//		Formula formula = (a) -> sqrt(a * 100);
	}
}

interface Formula
{
	double calculate(int a);

	default double sqrt(int a)
	{
		return Math.sqrt(a);
	}
}

