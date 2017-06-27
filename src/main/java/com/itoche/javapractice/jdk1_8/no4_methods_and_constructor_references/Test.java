package com.itoche.javapractice.jdk1_8.no4_methods_and_constructor_references;

/**
 * Created by ZHANGHANYI5 on 2017/6/27.
 *
 * 方法与构造函数引用
 */
public class Test
{
	public static void main(String[] args)
	{
		Converter<String, Integer> converter = Integer::valueOf;
		Integer converted = converter.convert("123");
		System.out.println(converted);   // 123
		System.out.println("java8允许你使用 :: 关键字来传递方法或者构造函数引用，"
				+ "上面的代码展示了如何引用一个静态方法，我们也可以引用一个对象的方法");
	}
}

@FunctionalInterface
interface Converter<F, T>
{
	T convert(F from);
}
