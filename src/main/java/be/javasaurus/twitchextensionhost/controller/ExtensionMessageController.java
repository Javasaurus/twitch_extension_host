package be.javasaurus.twitchextensionhost.controller;

import be.javasaurus.twitchextensionhost.models.Message;
import be.javasaurus.twitchextensionhost.models.TextMessage;
import be.javasaurus.twitchextensionhost.models.TextMessages;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author kenne
 */
@Controller
@CrossOrigin(allowCredentials="false")
public class ExtensionMessageController {

    @Value("${secret_key}")
    private String secret_key;

    private MessageHandler messageHandler = new MessageHandler();

    @CrossOrigin
    @MessageMapping("/incoming")
    @SendTo("/topic/incoming")
    public Message handleIncomingMessage(TextMessage message) throws Exception {
        messageHandler.addMessage(message);
        return new Message(message.getText() + " was submitted !");
    }

    @CrossOrigin
    @GetMapping("/view")
    @ResponseBody
    public TextMessages viewOutgoingMessage(@RequestParam(name = "secret_key", required = true, defaultValue = "445884522") String secret, Model model) {
        boolean isAuthorized = secret.equals(secret_key);
        TextMessages tmp = new TextMessages();
        tmp.setId(System.currentTimeMillis());
        if (isAuthorized) {
            tmp.setMessages(messageHandler.getMessages());
        } else {
            tmp.setState("ERR - unauthorized");
        }
        return tmp;
    }

    @CrossOrigin
    @GetMapping("/clear")
    @ResponseBody
    public TextMessages clearOutgoingMessages(@RequestParam(name = "secret_key", required = true, defaultValue = "445884522") String secret, Model model) {
        boolean isAuthorized = secret.equals(secret_key);
        TextMessages tmp = new TextMessages();
        tmp.setId(System.currentTimeMillis());
        if (isAuthorized) {     
            messageHandler.clear();
            tmp.setState("OK - cleared queue");
        } else {
            tmp.setState("ERR - unauthorized");
        }
        return tmp;
    }

}
