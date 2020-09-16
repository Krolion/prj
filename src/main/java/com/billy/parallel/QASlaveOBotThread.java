package com.billy.parallel;

import com.billy.model.telegram.QASlaveOBot;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import javax.inject.Singleton;


@Component
@Singleton
public class QASlaveOBotThread extends Thread {
    public TelegramBotsApi telegramBotsApi;
    public QASlaveOBot bot;

    private static int counter = 0;
    public int num;

    public QASlaveOBotThread(TelegramBotsApi telegramBotsApi, QASlaveOBot bot) {
        super("Поток" + ++counter);

        num = counter;

        this.telegramBotsApi = telegramBotsApi;
        this.bot = bot;

        System.out.println("Создан поток " + num + ": " + this);
        start(); // Запускаем поток
    }

    public void run() {
        System.out.println("Поток " + num + " запущен...");

        try {
            telegramBotsApi.registerBot(bot);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
