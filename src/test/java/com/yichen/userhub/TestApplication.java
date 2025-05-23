package com.yichen.userhub;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author: tyrzhang
 * @date: 2024/12/13 10:26
 * @description:
 */
@MapperScan("com.yichen.userhub.dao")
@SpringBootApplication(scanBasePackages = "com.yichen.userhub")
public class TestApplication {
    private static Logger logger = LoggerFactory.getLogger(TestApplication.class);
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(TestApplication.class);
        ConfigurableApplicationContext context = application.run(args);
        logger.info("启动端口: {}", context.getEnvironment().getProperty("local.server.port"));
    }

}
