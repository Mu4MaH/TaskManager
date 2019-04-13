package org.mu4mah.command.task;

import org.mu4mah.controller.Bootstrap;
import org.mu4mah.command.AbstractCommand;
import org.mu4mah.entity.Project;
import org.mu4mah.entity.Task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskCreateCommand extends AbstractCommand {

    private final String COMMAND = "tc";
    private final String DESCRIPTION = "Создать задачу";
    private final boolean isSecure = true;

    @Override
    public String getCommand() {
        return COMMAND;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public void execute(final Bootstrap bootstrap) throws Exception {
        final Task task = new Task();
        System.out.print("Введите название задачи: ");
        task.setName(bootstrap.getNextLine());
        System.out.print("");
        task.setDateStart(new Date());
        System.out.print("Введите расчётный срок исполнения задачи в виде ГГГГ-ММ-ДД: ");
        final String dateEnd = bootstrap.getNextLine();
        task.setDateEnd(new SimpleDateFormat("yyyy-MM-dd").parse(dateEnd));
        System.out.println("Будете сейчас назначать задачу на проект y(enter)/n? ");
        if (bootstrap.getNextLine().toLowerCase().equals("n")) {
            bootstrap.getTaskService().persist(task);
            return;
        }
        int idx;
        final List<Project> projects = new ArrayList<>(bootstrap.getProjectService().findAll());
        if (projects.size() > 0) {
            int size = projects.size();
            for (idx = 0; idx < size; idx++) {
                System.out.println((idx + 1) + ". " + projects.get(idx).toString());
            }
            System.out.print("Выберите номер проекта на который будет назначена задача: ");
            final int id = bootstrap.getNextInt();
            if (id <= size) {
                final String uidSelected = projects.get(id - 1).getUid();
                if (uidSelected.isEmpty()) {
                    bootstrap.getTaskService().persist(task);
                    return;
                }
                task.setParentProjectUid(uidSelected);
                bootstrap.getTaskService().persist(task);
            } else System.out.println("Нет такого проекта. Сохраняется без назначения.");
        } else{
            System.out.println("Список проектов пуст.");
        }
        bootstrap.getTaskService().persist(task);

    }

    @Override
    public boolean isSecure() {
        return isSecure;
    }

}
