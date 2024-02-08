package com.example.SpringData_5DZ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@EnableAspectJAutoProxy



@SpringBootApplication
public class SpringData5DzApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringData5DzApplication.class, args);
	}

}
