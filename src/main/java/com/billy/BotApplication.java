package com.billy;

import com.billy.model.telegram.QASlaveOBot;
import com.billy.model.telegram.QASlavePBot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class BotApplication {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        QASlaveOBot qaSlaveOBot = new QASlaveOBot();
        QASlavePBot qaSlavePBot = new QASlavePBot();

        try {
            telegramBotsApi.registerBot(qaSlaveOBot);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
