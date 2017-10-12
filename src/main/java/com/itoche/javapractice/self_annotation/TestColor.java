package com.itoche.javapractice.self_annotation;

import java.lang.annotation.*;

/**
 * Created by ZHANGHANYI5 on 2017/10/12.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestColor
{

	enum Color
	{
		BLUE, GREEN, RED
	};


	Color color() default Color.BLUE;
}
