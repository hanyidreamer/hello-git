package com.itoche.javapractice.jdk1_8.no7_access_object_fields_and_static_variables;

/**
 * Created by ZHANGHANYI5 on 2017/6/27.
 *
 * 访问对象字段与静态变量
 */
public class Test
{
	// 和本地变量不同的是，lambda内部对于实例的字段以及静态变量是即可读又可写。该行为和匿名对象是一致的
	static int outerStaticNum;
	int outerNum;

	void testScopes()
	{
		Converter<Integer, String> stringConverter1 = (from) -> {
			outerNum = 23;
			return String.valueOf(from);
		};

		Converter<Integer, String> stringConverter2 = (from) -> {
			outerStaticNum = 72;
			return String.valueOf(from);
		};
	}
}

@FunctionalInterface
interface Converter<F, T>
{
	T convert(F from);
}
