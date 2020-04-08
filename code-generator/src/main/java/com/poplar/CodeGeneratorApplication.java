package com.poplar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.poplar.dao")
public class CodeGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeGeneratorApplication.class, args);
	}
}
