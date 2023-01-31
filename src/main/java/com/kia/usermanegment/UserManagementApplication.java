package com.kia.usermanegment;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserManagementApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(UserManagementApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("This is my default Configurations");
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
