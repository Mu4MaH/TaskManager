package org.mu4mah.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.mu4mah.api.entity.AbstractEntity;

@Setter
@Getter
@NoArgsConstructor
public class Assignee extends AbstractEntity {

    private String taskUid;
    private String employeeUid;

    public boolean equals(@NotNull Assignee assignee) {
        return (taskUid.equals(assignee.taskUid) && employeeUid.equals(assignee.employeeUid));
    }
}
