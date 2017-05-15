package com.itoche.javapractice.api;

/**
 * Created by ZHANGHANYI5 on 2017/5/12.
 */
public class IdentitySyncLogInput implements java.io.Serializable
{
	private static final long serialVersionUID = -7361501458936582552L;

	private Long mId;				// 会员id
	private Long cId;				// 身份信息编号
	private String sCreateTime;		// 成功推送会员系统时间
	private String sUpdateTime;		// 成功推送会员系统时间

	public Long getmId()
	{
		return mId;
	}
	public void setmId(Long mId)
	{
		this.mId = mId;
	}

	public Long getcId()
	{
		return cId;
	}
	public void setcId(Long cId)
	{
		this.cId = cId;
	}

	public String getsCreateTime()
	{
		return sCreateTime;
	}
	public void setsCreateTime(String sCreateTime)
	{
		this.sCreateTime = sCreateTime;
	}

	public String getsUpdateTime()
	{
		return sUpdateTime;
	}
	public void setsUpdateTime(String sUpdateTime)
	{
		this.sUpdateTime = sUpdateTime;
	}
}
