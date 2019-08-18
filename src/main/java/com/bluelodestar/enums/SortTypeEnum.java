package main.java.com.bluelodestar.enums;

public enum SortTypeEnum {
    SELECT_SORT("2","Do SELECT sort."),
    BUBBLE_SORT("1","Do bubble sort.");
    private String value;
    private String messageText;

    public String getValue() {
        return value;
    }

    public String getMessageText() {
        return this.messageText;
    }

    private SortTypeEnum(String value, String messageText) {
        this.value = value;
        this.messageText = messageText;
    }
}
