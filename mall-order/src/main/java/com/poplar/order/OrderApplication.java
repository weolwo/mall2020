package com.poplar.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.annotation.ManagedBean;

/**
 * Create BY poplar ON 2020/4/3
 */
@SpringBootApplication
@ManagedBean(value = "com.poplar.order.dao")
@EnableDiscoveryClient
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class);
    }
}
