package tech.buildrun.magalums.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tech.buildrun.magalums.controller.dto.ScheduleNotificationRequest;
import tech.buildrun.magalums.controller.dto.ScheduleNotificationResponse;
import tech.buildrun.magalums.entity.Notification;
import tech.buildrun.magalums.entity.StatusType;
import tech.buildrun.magalums.notification.NotificationFactory;
import tech.buildrun.magalums.notification.SendNotification;
import tech.buildrun.magalums.repository.NotificationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class NotificationService {
    Logger logger = LoggerFactory.getLogger(NotificationService.class);

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(ScheduleNotificationRequest dto) {
        notificationRepository.save(dto.toNotification());
    }

    public Optional<Notification> findById(Long notificationId) {
        return notificationRepository.findById(notificationId);
    }

    public void cancelNotification(Long notificationId) {
        var notification = findById(notificationId);
        if (notification.isPresent()) {
            notification.get().cancel();
            notificationRepository.save(notification.get());
        }
    }

    public void checkAndSend(LocalDateTime dateTime) {
        var notifications = notificationRepository.findByStatusInAndDateTimeBefore(
                List.of(StatusType.PENDING, StatusType.ERROR),
                dateTime
        );
        logger.info("Found {} notifications to send", notifications.size());

        notifications.forEach(sendNotification());
    }

    private Consumer<Notification> sendNotification() {
        return n -> {
            try {
                SendNotification sendNotification = NotificationFactory.getNotification(n.getChannel());
                sendNotification.send(n.getDestination(), n.getMessage());
                n.send();
                notificationRepository.save(n);
            } catch (Exception e) {
                n.errorSending();
                notificationRepository.save(n);
            }
        };
    }

    public List<ScheduleNotificationResponse> findAll() {
        return notificationRepository
                .findAll().stream().map(ScheduleNotificationResponse::fromNotification).toList();
    }
}
