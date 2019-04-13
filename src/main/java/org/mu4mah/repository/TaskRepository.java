package org.mu4mah.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mu4mah.entity.Task;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskRepository {

    private final Map<String, Task> staff = new HashMap<>();

    public void persist(Task task) {
        staff.put(task.getUid(), task);
    }

    @Nullable
    public Task findOne(String uid) {
        return staff.get(uid);
    }

    @NotNull
    public Collection<Task> findAll() {
        return staff.values();
    }

    public void remove(String uid) {
        staff.remove(uid);
    }

    public void removeAll() {
        staff.clear();
    }

    public void merge(List<Task> list) {
        for (Task e : list) {
            staff.put(e.getUid(), e);
        }
    }

}
