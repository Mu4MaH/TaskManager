package org.mu4mah.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mu4mah.api.entity.AbstractEntity;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class Task extends AbstractEntity {

    private String uid = String.valueOf(UUID.randomUUID());
    private String parentProjectUid = "";
    private String name = "";
    private Date dateStart = new Date();
    private Date dateEnd;

    @Override
    public String toString() {
        return "uid: " + uid + " : " +
                "название задачи: " + name + " : " +
                "проект: " + parentProjectUid + " : " +
                "срок окончания: " + dateEnd;
    }
}
