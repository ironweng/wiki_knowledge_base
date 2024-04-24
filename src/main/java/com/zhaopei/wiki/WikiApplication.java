package com.zhaopei.wiki;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.util.logging.Logger;

@Slf4j
@SpringBootApplication
public class WikiApplication {
    public static void main(String[] args) {
        SpringApplication app=new SpringApplication(WikiApplication.class);
        Environment env=app.run(args).getEnvironment();
        log.info("启动成功!");
        log.info("地址:\thttp://127.0.0.1:{}",env.getProperty("server.port"));
    }
}
