package tech.buildrun.magalums.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.buildrun.magalums.exception.NotificationException;

public class WhatsappNotification implements SendNotification {
    private static final Logger logger = LoggerFactory.getLogger(WhatsappNotification.class);

    @Override
    public void send(String destination, String message) throws NotificationException {
        logger.info("Sending Whatsapp message to {} with message: {}", destination, message);
    }
}
