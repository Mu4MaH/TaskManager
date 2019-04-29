package org.mu4mah.api.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public abstract class AbstractEntity {
    private final String UID = UUID.randomUUID().toString();
    private String name;
    private Date dateStart;
    private Date dateEnd;

}
