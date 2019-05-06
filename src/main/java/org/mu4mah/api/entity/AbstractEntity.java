package org.mu4mah.api.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public abstract class AbstractEntity {
    private final String UID = UUID.randomUUID().toString();
    private String name;
    private LocalDate dateStart;
    private LocalDate dateEnd;

}
