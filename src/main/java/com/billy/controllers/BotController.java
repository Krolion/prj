package com.billy.controllers;

import com.billy.BotApplication;
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

    public BotApplication botApplication;

    public BotController(BotApplication botApplication) {
        this.botApplication = botApplication;
    }

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("send")
    public String send_message() {
        botApplication.qaSlaveOBotThread.bot.sendMessage();
        botApplication.qaSlavePBotThread.bot.sendMessage();
        return "i'm working on it";
    }
}





