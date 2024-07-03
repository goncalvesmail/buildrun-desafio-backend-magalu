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
}
