package com.billy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BotControllerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BotControllerApplication.class, args);
    }

}
