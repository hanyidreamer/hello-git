package com.itoche.javapractice.self_annotation;

/**
 * Created by ZHANGHANYI5 on 2017/10/12.
 */
public class TestBean
{
	@TestColor(color = TestColor.Color.GREEN)
	private String testColor;

	public String getTestColor()
	{
		return testColor;
	}

	public void setTestColor(String testColor)
	{
		this.testColor = testColor;
	}

	public static void main(String[] args)
	{
		System.out.println(new TestBean().getTestColor());
	}
}
