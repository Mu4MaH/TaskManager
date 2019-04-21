package org.mu4mah.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mu4mah.api.entity.AbstractEntity;
import org.mu4mah.api.repository.IRepository;
import org.mu4mah.entity.Task;

import java.util.*;

public class TaskRepository implements IRepository {

    private final Map<String, AbstractEntity> stuff = new HashMap<>();

    public void persist(AbstractEntity task) {
        stuff.put(task.getUID(), task);
    }

    @Nullable
    public AbstractEntity findOne(String uid) {
        return stuff.get(uid);
    }

    @NotNull
    public List<AbstractEntity> findAll() {
        return new ArrayList<>(stuff.values());
    }

    public void remove(String uid) {
        stuff.remove(uid);
    }

    public void removeAll() {
        stuff.clear();
    }

    public void merge(@NotNull List<Task> list) {
        for (Task e : list) {
            stuff.put(e.getUid(), e);
        }
    }

}
