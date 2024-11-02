package com.kodilla.exception.nullpointer;

public class MessageSender {
    public void sendMessageTo(User user,String message) throws MessageNotSentException {
        if(user == null) {
            throw new MessageNotSentException("User is null, cannot send message!");
        }else {
            System.out.println("Sending message: " + message + " to: " + user.getName());
            throw new NullPointerException("Object User was null");
        }
    }
}
