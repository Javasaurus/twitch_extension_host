package be.javasaurus.twitchextensionhost.models;

import java.util.ArrayList;

/**
 *
 * @author kenne
 */
public class TextMessages {

    private long id;
    private ArrayList<TextMessage> messages;
    private String state;

    public TextMessages() {
    }

    public TextMessages(long id, ArrayList<TextMessage> messages) {
        this.id = id;
        this.messages = messages;
        this.state = "";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<TextMessage> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<TextMessage> messages) {
        this.messages = messages;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
