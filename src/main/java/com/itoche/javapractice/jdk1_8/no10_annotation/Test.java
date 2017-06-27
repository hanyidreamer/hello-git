package com.itoche.javapractice.jdk1_8.no10_annotation;

import java.lang.annotation.Repeatable;

/**
 * Created by ZHANGHANYI5 on 2017/6/27.
 */
public class Test
{
}

@interface Hints
{
	Hint[] value();
}

@Repeatable(Hints.class)
@interface Hint
{
	String value();
}
