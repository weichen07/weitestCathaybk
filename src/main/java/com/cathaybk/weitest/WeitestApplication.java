package com.cathaybk.weitest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@MapperScan("com.cathaybk.weitest.mapper")
public class WeitestApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeitestApplication.class, args);
	}

}
