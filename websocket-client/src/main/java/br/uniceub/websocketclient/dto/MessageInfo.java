package br.uniceub.websocketclient.dto;

public class MessageInfo {

    private String id;
    private String content;

    public MessageInfo() { }

    public MessageInfo(String content) {
        this.content = content;
    }

    public MessageInfo(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageInfo{" +
            "id='" + id + '\'' +
            ", content='" + content + '\'' +
            '}';
    }
}
