package org.mu4mah.repository;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.mu4mah.entity.Assignee;
import org.mu4mah.entity.Task;

import java.util.*;

@NoArgsConstructor
public class AssigneeRepository {

    private final Set<Assignee> assigneeSet
            = new HashSet<>();

    public void addAssignee(@NotNull Assignee assignee) {
        assigneeSet
                .add(assignee);
    }

    @NotNull
    public List<String> getTasksByEmployee(@NotNull String uid) {
        List<String> output = new ArrayList<>();
        for (Assignee a : assigneeSet
        ) {
            if (uid.equals(a.getEmployeeUid())) {
                output.add(a.getTaskUid());
            }
        }
        return output;
    }

    @NotNull
    public List<String> getEmployeesByTask(@NotNull String uid) {
        List<String> output = new ArrayList<>();
        for (Assignee a : assigneeSet
        ) {
            if (uid.equals(a.getTaskUid())) {
                output.add(a.getEmployeeUid());
            }
        }
        return output;
    }

    public void removeAssignee(@NotNull Assignee assignee) {
        assigneeSet.remove(assignee);
    }

    public void removeAll() {
        assigneeSet.clear();
    }

    public void merge (@NotNull List<Assignee> list) {
        assigneeSet.clear();
        assigneeSet.addAll(list);
    }

}


