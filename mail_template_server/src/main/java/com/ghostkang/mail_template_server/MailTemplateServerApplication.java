package com.ghostkang.mail_template_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.ghostkang.mail_template_server.dao")
public class MailTemplateServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailTemplateServerApplication.class, args);
    }

}
