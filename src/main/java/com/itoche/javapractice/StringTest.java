package com.itoche.javapractice;

public class StringTest
{

	public static void main(String[] args)
	{
		String aString = "000";
		test(aString);
		System.out.println("String:" + aString);

		StringBuffer stringBuffer = new StringBuffer("000");
		test1(stringBuffer);
		System.out.println("stringBuffer:" + stringBuffer);

		StringBuilder stringBuilder = new StringBuilder("000");
		test2(stringBuilder);
		System.out.println("stringBuilder:" + stringBuilder);

	}

	public static void test(String a)
	{
		a += "1";
	}

	public static void test1(StringBuffer a)
	{
		a.append("1");
	}

	public static void test2(StringBuilder a)
	{
		a.append("1");
	}
}
