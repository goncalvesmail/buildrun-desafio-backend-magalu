package tech.buildrun.magalums.controller.dto;

import tech.buildrun.magalums.entity.ChannelType;
import tech.buildrun.magalums.entity.Notification;

import java.time.LocalDateTime;

public record ScheduleNotificationRequest(LocalDateTime dateTime,
                                          String destination,
                                          String message,
                                          String channel) {

    public Notification toNotification() {
        return new Notification(
            dateTime,
            destination,
            message,
            ChannelType.fromDescription(channel)
        );
    }

    public static Object fromNotification(Notification notification) {
        return new ScheduleNotificationRequest(
            notification.getDateTime(),
            notification.getDestination(),
            notification.getMessage(),
            notification.getChannel().getDescription()
        );
    }
}
