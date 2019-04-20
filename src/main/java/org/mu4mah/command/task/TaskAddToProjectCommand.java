package org.mu4mah.command.task;

import org.jetbrains.annotations.NotNull;
import org.mu4mah.api.entity.AbstractEntity;
import org.mu4mah.command.AbstractCommand;
import org.mu4mah.controller.Bootstrap;
import org.mu4mah.entity.Project;
import org.mu4mah.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskAddToProjectCommand extends AbstractCommand {

    final String COMMAND = "ta";
    final String DESCRIPTION = "Назначить задачу на порект.";

    @NotNull
    @Override
    public String getCommand() {
        return COMMAND;
    }

    @NotNull
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public void execute(Bootstrap bootstrap) throws Exception {
        int idx;
        final List<AbstractEntity> tasks = new ArrayList<>(bootstrap.getTaskService().findAll());
        if (tasks.size() == 0) {
            System.out.println("Список задач пуст.");
            return;
        }
        int size = tasks.size();
        for (idx = 0; idx < size; idx++ ){
            System.out.println((idx + 1) + ". " + tasks.get(idx).toString());
        }
        System.out.print("Выберите номер задачи: ");
        int select = bootstrap.getNextInt();
        final String taskId = tasks.get(select-1).getUID();
        final List<AbstractEntity> projects = new ArrayList<>(bootstrap.getProjectService().findAll());
        if (projects.size() == 0) {
            System.out.println("Список проектов пуст.");
            return;
        }
        size = projects.size();
        for (idx = 0; idx < size; idx++ ){
            System.out.println((idx + 1) + ". " + projects.get(idx).toString());
        }
        System.out.print("Выберите номер проекта, которому принадлежит выбранная задача: ");
        select = bootstrap.getNextInt();
        if (select >= size) {
            System.out.println("Нет такого проекта.");
            return;
        }
        @NotNull final String uidSelected = projects.get(select-1).getUID();
        Task task = new Task();
        task = bootstrap.getTaskService().findOne(taskId);
        task.setParentProjectUid(uidSelected);
        bootstrap.getTaskService().persist(task);
    }

    @Override
    public boolean isSecure() {
        return false;
    }
}
