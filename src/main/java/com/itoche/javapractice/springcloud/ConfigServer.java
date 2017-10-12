package com.itoche.javapractice.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by ZHANGHANYI5 on 2017/6/9.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer
{
	public static void main(String[] args)
	{
		SpringApplication.run(ConfigServer.class, args);
	}
}
