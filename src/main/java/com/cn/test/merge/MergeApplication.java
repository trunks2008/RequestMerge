package com.cn.test.merge;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cn.test.merge.mapper")
public class MergeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MergeApplication.class, args);
    }

}
