package com.bosssoft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.bosssoft.mapper")//可以写在MybatisplusConfig中
public class RbacPermissionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RbacPermissionsApplication.class, args);
    }

}
