package org.mu4mah.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mu4mah.entity.Project;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectRepository {

    private final Map<String, Project> staff = new HashMap<>();

    public void persist(Project project) {
        staff.put(project.getUid(), project);
    }

    @Nullable
    public Project findOne(String uid) {
        return staff.get(uid);
    }

    @NotNull
    public Collection<Project> findAll() {
        return staff.values();
    }

    public void remove(String uid) {
        staff.remove(uid);
    }

    public void removeAll() {
        staff.clear();
    }

    public void merge(List<Project> list) {
        for (Project e : list) {
            staff.put(e.getUid(), e);
        }
    }

}
