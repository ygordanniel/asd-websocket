package br.uniceub.websocketserver.dto;

public class ClientInfo {

    private String sessionId;
    private String remoteAddress;

    public ClientInfo(String sessionId, String remoteAddress) {
        this.sessionId = sessionId;
        this.remoteAddress = remoteAddress;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    @Override
    public String toString() {
        return "ClientInfo{" +
            "sessionId='" + sessionId + '\'' +
            ", remoteAddress='" + remoteAddress + '\'' +
            '}';
    }
}
