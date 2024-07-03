package tech.buildrun.magalums.notification;

import tech.buildrun.magalums.exception.NotificationException;

public interface SendNotification {
    void send(String destination, String message) throws NotificationException;
}
