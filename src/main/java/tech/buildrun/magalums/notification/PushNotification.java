package tech.buildrun.magalums.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.buildrun.magalums.exception.NotificationException;

public class PushNotification implements SendNotification {
    private static final Logger logger = LoggerFactory.getLogger(PushNotification.class);

    @Override
    public void send(String destination, String message) throws NotificationException {
        logger.info("Sending push notification to {} with message: {}", destination, message);
    }
}
