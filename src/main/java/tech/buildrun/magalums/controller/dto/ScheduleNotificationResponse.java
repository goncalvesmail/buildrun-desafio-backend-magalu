package tech.buildrun.magalums.controller.dto;

import tech.buildrun.magalums.entity.Notification;

import java.time.LocalDateTime;

public record ScheduleNotificationResponse(
        Long id,
        LocalDateTime dateTime,
        String destination,
        String message,
        String channel,
        String status) {

    public static ScheduleNotificationResponse fromNotification(
            Notification notification) {
        return new ScheduleNotificationResponse(
            notification.getNotificationId(),
            notification.getDateTime(),
            notification.getDestination(),
            notification.getMessage(),
            notification.getChannel().getDescription(),
            notification.getStatus().getDescription()
        );
    }

}