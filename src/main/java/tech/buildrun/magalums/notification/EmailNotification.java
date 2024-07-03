package tech.buildrun.magalums.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.buildrun.magalums.exception.NotificationException;

public class EmailNotification implements SendNotification {
    private static final Logger logger = LoggerFactory.getLogger(EmailNotification.class);

    @Override
    public void send(String destination, String message) throws NotificationException {
        logger.info("Sending email to {} with message: {}", destination, message);
    }
}
