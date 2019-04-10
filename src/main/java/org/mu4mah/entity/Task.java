package org.mu4mah.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class Task {

    private String uid = String.valueOf(UUID.randomUUID());
    private String parentProjectUid;
    private String name;
    private Date start;
    private Date end;

}
