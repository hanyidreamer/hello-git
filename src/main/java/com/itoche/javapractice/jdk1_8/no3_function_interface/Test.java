package com.itoche.javapractice.jdk1_8.no3_function_interface;

/**
 * Created by ZHANGHANYI5 on 2017/6/27.
 */
public class Test
{
	public static void main(String[] args)
	{
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted);    // 123
	}
}

@FunctionalInterface
interface Converter<F, T>
{
	T convert(F from);
}
