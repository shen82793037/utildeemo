package main.java.com.bluelodestar.enums;

public enum MessageEnum {
    UNKNOWN_ERROR("unknown error"),
    NOT_A_NUMBER("not a number"),
    SUCCESSFULLY_CREATE("Successfully create!");
    private String messageText;
    public String getMessageText() {
        return this.messageText;
    }

    private MessageEnum(String messageText) {
        this.messageText = messageText;
    }
}
