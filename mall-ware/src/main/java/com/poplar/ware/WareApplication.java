package com.poplar.ware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.ManagedBean;

/**
 * Create BY poplar ON 2020/4/3
 */
@SpringBootApplication
@ManagedBean(value = "com.poplar.ware.dao")
public class WareApplication {
    public static void main(String[] args) {
        SpringApplication.run(WareApplication.class);
    }
}
