package org.mu4mah.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mu4mah.api.entity.AbstractEntity;
import org.mu4mah.api.repository.IRepository;
import org.mu4mah.entity.Project;

import java.util.*;

public class ProjectRepository implements IRepository {

    private final Map<String, AbstractEntity> stuff = new HashMap<>();

    public void persist(AbstractEntity project) {
        stuff.put(project.getUID(), project);
    }

    @Nullable
    public AbstractEntity findOne(String uid) {
        return stuff.get(uid);
    }

    @NotNull
    public ArrayList<AbstractEntity> findAll() {
        return new ArrayList<>(stuff.values());
    }

    public void remove(String uid) {
        stuff.remove(uid);
    }

    public void removeAll() {
        stuff.clear();
    }

    public void merge(@NotNull List<Project> list) {
        for (Project e : list) {
            stuff.put(e.getUid(), e);
        }
    }

}
