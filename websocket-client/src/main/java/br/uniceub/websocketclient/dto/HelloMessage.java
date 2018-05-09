package br.uniceub.websocketclient.dto;

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
}
