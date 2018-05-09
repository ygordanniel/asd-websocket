package br.uniceub.websocketserver.resource;

import br.uniceub.websocketserver.dto.Greeting;
import br.uniceub.websocketserver.dto.HelloMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    private Logger logger = LogManager.getLogger(GreetingController.class);

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Greeting greeting(HelloMessage message, SimpMessageHeaderAccessor headerAccessor) throws Exception {
        logger.info("Recived message: " + message);
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getFrom()) +
            "! You said \'" + message.getText() + "\'");
    }

}
