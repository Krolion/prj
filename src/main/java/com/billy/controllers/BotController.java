package com.billy.controllers;

import com.billy.BotApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
@RequestMapping("/api/bot/")
public class BotController {

    public BotApplication botApplication;

    public BotController(BotApplication botApplication) {
        this.botApplication = botApplication;
    }

    @GetMapping("hello")
    public String hello(){
        return "Hi, i'm a BotController";
    }

    @GetMapping("send")
    public String send_message() {
        botApplication.qaSlaveOBotThread.bot.sendMessage();
        botApplication.qaSlavePBotThread.bot.sendMessage();
        return "i'm working on it";
    }

    @GetMapping("last_update")
    public String last_update() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(botApplication.qaSlaveOBotThread.bot.lastUpdate);
    }

    @GetMapping("last_message")
    public String last_message() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(botApplication.qaSlaveOBotThread.bot.lastMessage);
    }
}





