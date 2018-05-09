package br.uniceub.websocketserver.dto;

public class HelloMessage {

    private String from;
    private String text;

    public HelloMessage() { }

    public HelloMessage(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "HelloMessage{" +
            "from='" + from + '\'' +
            ", text='" + text + '\'' +
            '}';
    }
}
