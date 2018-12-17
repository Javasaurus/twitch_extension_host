/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.javasaurus.twitchextensionhost.models;

/**
 *
 * @author kenne
 */
public class TextMessage {

    private String userID;
    private String text;

    public TextMessage() {
    }

    public TextMessage(String userID, String text) {
        this.userID = userID;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

}
