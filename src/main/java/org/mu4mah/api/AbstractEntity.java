package org.mu4mah.api;

import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class AbstractEntity {
    private final String uid = UUID.randomUUID().toString();
}
