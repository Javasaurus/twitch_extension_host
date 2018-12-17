package be.javasaurus.twitchextensionhost.controller;

import be.javasaurus.twitchextensionhost.models.TextMessage;
import java.util.ArrayList;

/**
 *
 * @author kenne
 */
public class MessageHandler {

    private final ArrayList<TextMessage> messages = new ArrayList<TextMessage>();

    public MessageHandler() {

    }

    public ArrayList<TextMessage> getMessages() {
        return messages;
    }

    public void clear() {
        messages.clear();
    }

    public void addMessage(TextMessage textMessage) {
        messages.add(textMessage);
    }

}
