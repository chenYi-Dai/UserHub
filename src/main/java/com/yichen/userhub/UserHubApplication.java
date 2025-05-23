package com.yichen.userhub;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@MapperScan("com.yichen.userhub.dao")
@SpringBootApplication
public class UserHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserHubApplication.class, args);
    }

}
