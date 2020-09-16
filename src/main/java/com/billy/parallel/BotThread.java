package com.billy.parallel;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class BotThread extends Thread {
    private TelegramBotsApi telegramBotsApi;
    private TelegramLongPollingBot bot;

    private static int counter = 0;
    private int num;

    public BotThread(TelegramBotsApi telegramBotsApi, TelegramLongPollingBot bot) {
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
