package com.billy;

import com.billy.model.telegram.QASlaveOBot;
import com.billy.model.telegram.QASlavePBot;
import com.billy.parallel.BotThread;
import lombok.SneakyThrows;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class BotApplication {

    @SneakyThrows
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        QASlaveOBot qaSlaveOBot = new QASlaveOBot();
        QASlavePBot qaSlavePBot = new QASlavePBot();

        BotThread bot1 = new BotThread(telegramBotsApi, qaSlaveOBot);
        BotThread bot2 = new BotThread(telegramBotsApi, qaSlavePBot);

        while (bot1.isAlive() && bot2.isAlive())
        {
            System.out.println("I'm still working...");
            Thread.sleep(500);
        }
    }
}
