package org.mu4mah.api.entity;

import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class AbstractEntity {
    private final String UID = UUID.randomUUID().toString();
}
