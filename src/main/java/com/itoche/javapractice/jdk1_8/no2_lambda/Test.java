package com.itoche.javapractice.jdk1_8.no2_lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ZHANGHANYI5 on 2017/6/27.
 *
 * Lambda 表达式
 */
public class Test
{
	public static void main(String[] args)
	{
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

		System.out.println("默认");
		Collections.sort(names, new Comparator<String>()
		{
			@Override
			public int compare(String a, String b)
			{
				return b.compareTo(a);
			}
		});
		for (String name : names)
		{
			System.out.println(name);
		}

		System.out.println("lambda表达式");
		Collections.sort(names, (String a, String b) -> {
			return b.compareTo(a);
		});
		for (String name : names)
		{
			System.out.println(name);
		}

		System.out.println("对于函数体只有一行代码的，你可以去掉大括号{}以及return关键字");
		Collections.sort(names, (String a, String b) -> b.compareTo(a));
		for (String name : names)
		{
			System.out.println(name);
		}

		System.out.println("Java编译器可以自动推导出参数类型，所以你可以不用再写一次类型");
		Collections.sort(names, (a, b) -> b.compareTo(a));
		for (String name : names)
		{
			System.out.println(name);
		}
	}
}
