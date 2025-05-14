package com.bharat.team6.dto;

public class SwiftChatRequestDTO {
    private static String sender;
    private static String message;

    public static void setSender(String sender) {
        SwiftChatRequestDTO.sender = sender;
    }

    public static void setMessage(String message) {
        SwiftChatRequestDTO.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getSender() {
        return sender;
    }
}
