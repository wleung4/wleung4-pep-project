package Service;

import DAO.MessageDAO;
import Model.Message;

import java.util.*;

public class MessageService {
    private MessageDAO messageDAO;

    public MessageService() {
        messageDAO = new MessageDAO();
    }

    public MessageService(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    // create message
    public Message createMessage(Message message) {
        if (message.getMessage_text().length() > 255 || message.getMessage_text().length() <= 0) {
            return null;
        }
        return messageDAO.insertMessage(message);
    }

    // get all messages
    public List<Message> getAllMessages() {
        return messageDAO.getAllMessages();
    }

    // get message by message id
    public Message getMessageByMessageId(int message_id) {
        return messageDAO.getMessageByMessageId(message_id);
    }

    // delete message by message id
    public Message deleteMessageByMessageId(int message_id) {
        return messageDAO.deleteMessageByMessageId(message_id);
    }

    // update message by message id
    public Message updateMessageByMessageId(int message_id, Message message) {
        Message searchedMessage = messageDAO.getMessageByMessageId(message_id);
        if (searchedMessage == null) { 
            return null;
        } 
        
        if (message.getMessage_text().length() > 255 || message.getMessage_text().length() <= 0) {
            return null;
        }
        return messageDAO.updateMessageByMessageId(message_id, message);
    }

    // get all messages by account id
    public List<Message> getAllMessagesByAccountId(int account_id) {
        return messageDAO.getAllMessagesByAccountId(account_id);
    }
}
