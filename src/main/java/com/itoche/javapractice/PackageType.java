package com.itoche.javapractice;

public class PackageType
{
	public static void main(String[] args)
	{
		Integer aInteger = new Integer(1);
		Integer bInteger = new Integer(1);
		System.out.println(aInteger == bInteger);
		System.out.println(aInteger.equals(bInteger));
		System.out.println(aInteger.intValue() == bInteger.intValue());
	}
}
