package com.pokerstar.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.oas.annotations.EnableOpenApi;


@EnableOpenApi
@ServletComponentScan
@EnableAsync
@SpringBootApplication
@MapperScan(basePackages = {"com.pokerstar.api.domain.mapper"})
public class ApiApplication {

    public static void main(String[] args) {
        System.out.println("application start ................");
        SpringApplication.run(ApiApplication.class, args);
        System.out.println("application initial end ................");
    }

}
