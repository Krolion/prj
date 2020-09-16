package com.billy;

import com.billy.model.telegram.QASlaveOBot;
import com.billy.model.telegram.QASlavePBot;
import com.billy.parallel.QASlaveOBotThread;
import com.billy.parallel.QASlavePBotThread;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;

@Service
public class BotApplication {

    @Autowired
    public QASlaveOBotThread qaSlaveOBotThread;
    @Autowired
    public QASlavePBotThread qaSlavePBotThread;

    public BotApplication() {
        System.out.println("Я родился!");
    }
}
