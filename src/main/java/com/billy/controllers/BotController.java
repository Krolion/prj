package com.billy.controllers;

import com.billy.model.telegram.QAMasterBot;
import com.billy.model.telegram.QASlaveOBot;
import com.billy.model.telegram.QASlavePBot;
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

    @Autowired
    public QASlaveOBot qaSlaveOBot;
    @Autowired
    public QASlavePBot qaSlavePBot;
    @Autowired
    public QAMasterBot qaMasterBot;

    @GetMapping("hello")
    public String hello(){
        return "Hi, i'm a BotController";
    }

    @GetMapping("send")
    public String send_message() {
        qaSlaveOBot.sendMessage();
        qaSlavePBot.sendMessage();
        return "i'm working on it";
    }

    @GetMapping("last_update_o")
    public String last_update_o() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(qaSlaveOBot.lastUpdate);
    }

    @GetMapping("last_update_p")
    public String last_update_p() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(qaSlavePBot.lastUpdate);
    }

    @GetMapping("last_message")
    public String last_message() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(qaSlaveOBot.lastMessage);
    }
}





