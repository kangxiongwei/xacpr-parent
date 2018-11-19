package com.zhx.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 启动服务的类
 * Create by kangxiongwei on 2018/11/15 下午11:13
 */
@RestController
@SpringBootApplication(scanBasePackages = "com.zhx.demo")
@MapperScan("com.zhx.demo.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }

}
