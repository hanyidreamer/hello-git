package com.itoche.javapractice.bean;

/**
 * Created by ZHANGHANYI5 on 2017/5/9.
 */
public class Bean
{
	private String afterSalesMobile;     // 售后电话

	public String getAfterSalesMobile()
	{
		return afterSalesMobile;
	}

	public void setAfterSalesMobile(String afterSalesMobile)
	{
		this.afterSalesMobile = afterSalesMobile;
	}

	public static void main(String[] args)
	{
		int j = 11;
		for (int i = 0; i < 100; i++)
		{
			if (i != j && (i == 10 || i == 12))
				continue;
			System.out.println(i);
		}
	}
}
