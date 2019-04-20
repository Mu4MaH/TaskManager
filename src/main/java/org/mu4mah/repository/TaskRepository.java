package org.mu4mah.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mu4mah.api.entity.AbstractEntity;
import org.mu4mah.api.repository.IRepository;
import org.mu4mah.entity.Task;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskRepository implements IRepository {

    private final Map<String, AbstractEntity> staff = new HashMap<>();

    public void persist(AbstractEntity task) {
        staff.put(task.getUID(), task);
    }

    @Nullable
    public AbstractEntity findOne(String uid) {
        return staff.get(uid);
    }

    @NotNull
    public Collection<AbstractEntity> findAll() {
        return staff.values();
    }

    public void remove(String uid) {
        staff.remove(uid);
    }

    public void removeAll() {
        staff.clear();
    }

    public void merge(@NotNull List<Task> list) {
        for (Task e : list) {
            staff.put(e.getUid(), e);
        }
    }

}
