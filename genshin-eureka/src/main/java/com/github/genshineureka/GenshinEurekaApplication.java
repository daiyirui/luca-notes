package com.github.genshineureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @EnableEurekaServer 激活注册中心，激活相关配置
 */
@EnableEurekaServer
@SpringBootApplication
public class GenshinEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenshinEurekaApplication.class, args);
	}

}
