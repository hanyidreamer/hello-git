package com.itoche.javapractice.jdk1_8.no6_accessing_local_variables;

/**
 * Created by ZHANGHANYI5 on 2017/6/27.
 *
 * 访问局部变量
 */
public class Test
{
	public static void main(String[] args)
	{
		final int num = 1;
		Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);

		String result = stringConverter.convert(2);     // 3

		System.out.println(result);

		// 但是和匿名对象不同的是，这里的变量num可以不用声明为final，该代码同样正确
		int num1 = 1;
		Converter<Integer, String> stringConverter1 = (from) -> String.valueOf(from + num1);

		String result1 = stringConverter1.convert(2);     // 3

		System.out.println(result1);

		// 不过这里的num必须不可被后面的代码修改（即隐性的具有final的语义），例如下面的就无法编译：
		//		int num2 = 1;
		//		Converter<Integer, String> stringConverter2 = (from) -> String.valueOf(from + num2);
		//		num2 = 3;
	}
}

@FunctionalInterface
interface Converter<F, T>
{
	T convert(F from);
}
