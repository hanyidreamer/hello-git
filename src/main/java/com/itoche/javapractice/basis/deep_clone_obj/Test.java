package com.itoche.javapractice.basis.deep_clone_obj;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created by ZHANGHANYI5 on 2017/6/29.
 */
public class Test
{
	public static void main(String[] args)
	{
		try
		{
			ObjTest objTest = new ObjTest();

			// 传统赋值如果之后有操作会被改变
			//		ObjTest objTest1 = objTest;
			ObjTest objTest1 = (ObjTest) new Test().copy(objTest);

			objTest.setI(2);
			objTest.setStr("2");

			System.out.println(objTest1.getI() + "--" + objTest1.getStr());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @description: 深度拷贝对象
	 * @param objTest 需要序列化
	 * @return Object
	 * @author: zhanghanyi5
	 * @createTime: 2017/6/29 10:45
	 */
	public Object copy(ObjTest objTest) throws IOException, ClassNotFoundException
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(objTest);
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
		return ois.readObject();
	}
}

class ObjTest implements Serializable
{
	private static final long serialVersionUID = -2975102472903778152L;

	private Integer i = 1;
	private String str = "1";
	private Map<String, Object> map;
	private List<String> list;

	public Integer getI()
	{
		return i;
	}

	public void setI(Integer i)
	{
		this.i = i;
	}

	public String getStr()
	{
		return str;
	}

	public void setStr(String str)
	{
		this.str = str;
	}

	public Map<String, Object> getMap()
	{
		return map;
	}

	public void setMap(Map<String, Object> map)
	{
		this.map = map;
	}

	public List<String> getList()
	{
		return list;
	}

	public void setList(List<String> list)
	{
		this.list = list;
	}
}
