package com.example.youxihoutai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement //开启事务
@SpringBootApplication
@MapperScan("com.hou_tai.model.dao")  //Mapper映射，Mybatis-plus
@ComponentScan("com.hou_tai")   //扫描组件
public class YouXiHouTaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouXiHouTaiApplication.class, args);
    }

}
