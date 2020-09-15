package com.billy.controllers;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

/**
 * @author Evgeny Borisov
 */
@RestController
@RequestMapping("/api/")
public class BotController {

    @SneakyThrows
    public static void main(String[] args) {
    }

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}





