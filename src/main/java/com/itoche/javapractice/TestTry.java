package com.itoche.javapractice;

/**
 * Created by ZHANGHANYI5 on 2017/7/17.
 */
public class TestTry
{
	public static void main(String[] args)
	{
		try
		{
			System.out.println("try");
			throw new RuntimeException("try");
		}
		catch (Exception e)
		{
			System.out.println("catch");
			throw e;
		}
		finally
		{
			System.out.println("finally");
		}
	}
}
