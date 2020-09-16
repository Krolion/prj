package com.billy.model.telegram;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.inject.Singleton;


@Component
@Singleton
public class QASlaveOBot extends TelegramLongPollingBot {

    public int a = 0;
    public SendMessage lastMessage;
    public Update lastUpdate;

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getFrom().getFirstName()
                + " " + update.getMessage().getText());

        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        sendMessage.setText("Hello " + update.getMessage().getFrom().getFirstName() + " " + a);
        lastMessage = sendMessage;
        lastUpdate = update;
        a += 1;

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage() {
        try {
            lastMessage.setText("Кто-то меня потрогал!");
            execute(lastMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "test25673Bot";
    }

    @Override
    public String getBotToken() {
        return "1389370639:AAFpHBYG3eBgyrtFFQNh5wyhi-DIjBK5HFY";
    }
}