package tech.buildrun.magalums.entity;

import lombok.Getter;

@Getter
public enum ChannelType {
    EMAIL("email"),
    SMS("sms"),
    PUSH("push"),
    WHATSAPP("whatsapp");

    private final String description;

    ChannelType(String description) {
        this.description = description;
    }

    public static ChannelType fromDescription(String description) {
        for (ChannelType channelType : ChannelType.values()) {
            if (channelType.getDescription().equals(description)) {
                return channelType;
            }
        }
        return null;
    }
}
