package com.springcloud.UserProvider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;
@SpringBootApplication
@MapperScan(basePackages = "com.springcloud.user.mapper")
@ComponentScan(basePackages = {"com.springcloud"}) //如果启动类在com.springcloud下面 不必加,如果启动类不在com.springcloud要加

public class UserProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProviderApplication.class, args);
	}

}
