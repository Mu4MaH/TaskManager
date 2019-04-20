package org.mu4mah.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mu4mah.api.entity.AbstractEntity;
import org.mu4mah.entity.Project;
import org.mu4mah.repository.ProjectRepository;

import java.util.Collection;
import java.util.List;

public class ProjectService {

    private final ProjectRepository projectRepository = new ProjectRepository();

    public void persist(@NotNull Project project) {
        projectRepository.persist(project);
    }

    @Nullable public Project findOne(@NotNull String uid) {
        if (uid.isEmpty()) return null;
        return (Project) projectRepository.findOne(uid);
    }

    public @NotNull Collection<AbstractEntity> findAll() {
        return projectRepository.findAll();
    }

    public void remove(@NotNull String uid) {
        projectRepository.remove(uid);
    }

    public void removeAll() {
        projectRepository.removeAll();
    }

    public void merge(@NotNull List<Project> list) {
        projectRepository.merge(list);
    }

}
