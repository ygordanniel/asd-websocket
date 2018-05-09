package br.uniceub.websocketclient.thread;

import org.springframework.messaging.simp.stomp.StompSession;

public class Blabber implements Runnable {

    private StompSession session;

    public Blabber(StompSession session) {
        this.session = session;
    }

    @Override
    public void run() {

    }
}
