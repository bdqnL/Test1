package cn.bdqn;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableDubboConfiguration
public class UserProviderLauncher {
    public static void main(String[] args) {
        SpringApplication.run(UserProviderLauncher.class, args);
    }}
