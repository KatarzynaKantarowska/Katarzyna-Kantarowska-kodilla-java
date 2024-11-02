package com.kodilla.exception.nullpointer;

public class NullPointerExceptionRunner {
    public static void main(String[] args) throws MessageNotSentException {
        User user = null;
        MessageSender messageSender = new MessageSender();
        messageSender.sendMessageTo(user,"Hello!");

        try{
            messageSender.sendMessageTo(user,"Hello!");
        } catch (MessageNotSentException e) {
            System.out.println("Message is not send, but my program still running very well!");
        }
        System.out.println("Processing other logic!");
    }
}
