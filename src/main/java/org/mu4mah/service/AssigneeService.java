package org.mu4mah.service;

import org.jetbrains.annotations.NotNull;
import org.mu4mah.entity.Assignee;
import org.mu4mah.repository.AssigneeRepository;

import java.util.ArrayList;
import java.util.List;

public class AssigneeService {

    private  final AssigneeRepository assigneeRepository = new AssigneeRepository();

    public void persist(String employeeId, String taskId) {
        final Assignee assignee = new Assignee();
        assignee.setEmployeeUid(employeeId);
        assignee.setTaskUid(taskId);
        assigneeRepository.persist(assignee);
    }

    @NotNull
    public List<String> getTasksByEmployee(@NotNull String uid) {
        if (uid.isEmpty()) return new ArrayList<>();
        return assigneeRepository.getTasksByEmployee(uid);
    }

    @NotNull
    public List<String> getEmployeesByTask(@NotNull String uid) {
        if (uid.isEmpty()) return new ArrayList<>(0);
        return assigneeRepository.getEmployeesByTask(uid);
    }

    public void remove(@NotNull Assignee assignee) {
        assigneeRepository.removeAssignee(assignee);
    }

    public void removeAll() {
        assigneeRepository.removeAll();
    }

    public void merge (@NotNull List<Assignee> list) {
        this.removeAll();
        assigneeRepository.merge(list);
    }

    @NotNull public List<Assignee> findAll() {
        return assigneeRepository.findAll();
    }

}
