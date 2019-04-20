package org.mu4mah.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mu4mah.api.entity.AbstractEntity;
import org.mu4mah.entity.Task;
import org.mu4mah.repository.TaskRepository;

import java.util.Collection;
import java.util.List;

public class TaskService {

    private final TaskRepository taskRepository = new TaskRepository();

    public void persist(@NotNull Task task) {
        taskRepository.persist(task);
    }

    @Nullable
    public Task findOne(@NotNull String uid) {
        if (uid.isEmpty()) return null;
        return (Task) taskRepository.findOne(uid);
    }

    public @NotNull Collection<AbstractEntity> findAll() {
        return taskRepository.findAll();
    }

    public void remove(@NotNull String uid) {
        taskRepository.remove(uid);
    }

    public void removeAll() {
        taskRepository.removeAll();
    }

    public void merge(@NotNull List<Task> list) {
        taskRepository.merge(list);
    }

}
