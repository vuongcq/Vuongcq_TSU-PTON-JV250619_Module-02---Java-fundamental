package Session11.Ex3;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Message {
    // Khai báo thuộc tính
    private String sender;
    private String content;
    private LocalDateTime timestamp;

    //Constructor


    public Message() {
    }

    public Message(String sender, String content, LocalDateTime timestamp) {
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
    }

    //Method
    // Getter, setter

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", timestamp, sender, content);
    }
}
