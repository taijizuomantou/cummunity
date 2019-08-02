package com.nowcoder.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommunityApplication {

	public static void main(String[] args) {
		//启动tomcat，自动创建spring容器
		SpringApplication.run(CommunityApplication.class, args);
	}

}
