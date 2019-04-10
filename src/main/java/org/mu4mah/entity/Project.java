package org.mu4mah.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class Project {

    private final String uid = String.valueOf(UUID.randomUUID());
    private String name;
    private String description;
    Date dateStart;
    Date dateEnd;

    @Override
    public String toString() {
        return this.uid + " : " + this.name;
    }

}
