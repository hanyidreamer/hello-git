package com.itoche.javapractice.jdk1_8.no4_methods_and_constructor_references;

/**
 * Created by ZHANGHANYI5 on 2017/6/27.
 */
public class Test1
{
	public static void main(String[] args)
	{
		// 使用 Person::new 来获取Person类构造函数的引用，Java编译器会自动根据PersonFactory.create方法的签名来选择合适的构造函数。
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("Peter", "Parker");
		System.out.println("12345");
	}
}

class Person
{
	String firstName;
	String lastName;

	Person()
	{
	}

	Person(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
}

interface PersonFactory<P extends Person>
{
	P create(String firstName, String lastName);
}