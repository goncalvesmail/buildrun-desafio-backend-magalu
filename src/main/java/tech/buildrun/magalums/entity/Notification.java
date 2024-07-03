package tech.buildrun.magalums.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "tb_notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long notificationId;
    @Setter
    private LocalDateTime dateTime;
    @Setter
    private String destination;
    @Setter
    private String message;
    @Setter
    private ChannelType channel;
    private StatusType status;
    public Notification() {
    }

    public Notification(
            LocalDateTime dateTime,
            String destination, String message, ChannelType channel) {
        this.dateTime = dateTime;
        this.destination = destination;
        this.message = message;
        this.channel = channel;
        this.status = StatusType.PENDING;
    }

    @Transient
    public void cancel() {
        this.status = StatusType.CANCELED;
    }

    @Transient
    public void send() {
        this.status = StatusType.SUCCESS;
    }

    @Transient
    public void errorSending() {
        this.status = StatusType.ERROR;
    }
}
