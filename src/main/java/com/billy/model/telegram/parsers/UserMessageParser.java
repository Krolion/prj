package com.billy.model.telegram.parsers;

import org.springframework.stereotype.Component;


public class UserMessageParser {
    public String text = null;
    public boolean isCommand = false;
    private final String command;

    public UserMessageParser(String command) {
        this.command = "/" + command;
    }

    public UserMessageParser parseMessage(String message) {
        if (message.length() < command.length()) {
            isCommand = false;
            return this;
        }
        if (message.substring(0, command.length()).equals(command)) {
            isCommand = true;
            text = message.substring(command.length()).strip();
        }
        else isCommand = false;
        return this;
    }
}
