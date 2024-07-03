package tech.buildrun.magalums.notification;

import tech.buildrun.magalums.entity.ChannelType;

public class NotificationFactory {

    public static SendNotification getNotification(ChannelType channel) {
        return switch (channel) {
            case EMAIL -> new EmailNotification();
            case SMS -> new SmsNotification();
            case PUSH -> new PushNotification();
            case WHATSAPP -> new WhatsappNotification();
        };
    }
}
