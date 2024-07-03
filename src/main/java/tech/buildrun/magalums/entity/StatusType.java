package tech.buildrun.magalums.entity;

import lombok.Getter;

@Getter
public enum StatusType {
    PENDING( "pending"),
    SUCCESS( "success"),
    ERROR( "error"),
    CANCELED("canceled");

    private final String description;

    StatusType(String description) {
            this.description = description;
    }

    public static StatusType fromDescription(String description) {
        for (StatusType statusType : StatusType.values()) {
            if (statusType.getDescription().equals(description)) {
                return statusType;
            }
        }
        return null;
    }
}
