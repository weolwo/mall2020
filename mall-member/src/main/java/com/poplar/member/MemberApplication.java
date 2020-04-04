package com.poplar.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Create BY poplar ON 2020/4/3
 */
@SpringBootApplication
@MapperScan(value = "com.poplar.member.dao")
@EnableDiscoveryClient
@EnableFeignClients("com.poplar.member.feign")
public class MemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class);
    }
}
