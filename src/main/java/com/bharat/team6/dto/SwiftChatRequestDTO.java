package com.bharat.team6.dto;

public class SwiftChatRequestDTO {
    private static String sender;
    private static String message;

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getSender() {
        return sender;
    }
}
