package tech.buildrun.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.buildrun.magalums.entity.Notification;
import tech.buildrun.magalums.entity.StatusType;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByStatusInAndDateTimeBefore(List<StatusType> status, LocalDateTime dateTime);
}
