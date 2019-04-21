package org.mu4mah.entity;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mu4mah.controller.Bootstrap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Domain implements Serializable {

    private List<Project> projects;
    private List<Task> tasks;
    private List<Employee> employees;
    private List<Assignee> assignees;

    @NotNull public Domain createDomain(final Bootstrap bootstrap) {
        final List<Project> projects = (List)bootstrap.getProjectService().findAll();
        final List<Task> tasks = (List)bootstrap.getTaskService().findAll();
        final List<Employee> employees = (List)bootstrap.getEmployeeService().findAll();
        final List<Assignee> assignees = (List)bootstrap.getAssigneeService().findAll();
        final Domain domain = new Domain();
        domain.setProjects(projects);
        domain.setTasks(tasks);
        domain.setAssignees(assignees);
        domain.setEmployees(employees);
        return domain;
    }

    public void loadDomain (final Bootstrap bootstrap, final Domain domain) {
        final List<Project> projects = domain.getProjects();
        final List<Task> tasks = domain.getTasks();
        final List<Employee> employees = domain.getEmployees();
        final List<Assignee> assignees = domain.getAssignees();
        bootstrap.getProjectService().merge(projects);
        bootstrap.getTaskService().merge(tasks);
        bootstrap.getEmployeeService().merge(employees);
        bootstrap.getAssigneeService().merge(assignees);
    }


    @NotNull public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(@Nullable List<Project> projects) {
        if (projects == null) {
            this.projects = new ArrayList<Project>();
            return;
        }
        this.projects = projects;
    }

    @NotNull public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(@Nullable List<Task> tasks) {
        if (tasks == null) {
            this.tasks = new ArrayList<Task>();
            return;
        }
        this.tasks = tasks;
    }

    @NotNull public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(@Nullable List<Employee> employees) {
        if (employees == null) {
            this.employees = new ArrayList<Employee>();
            return;
        }
        this.employees = employees;
    }

    @NotNull public List<Assignee> getAssignees() {
        return assignees;
    }

    public void setAssignees(@Nullable List<Assignee> assignees) {
        if (assignees == null) {
            this.assignees = new ArrayList<Assignee>();
            return;
        }
        this.assignees = assignees;
    }
}
