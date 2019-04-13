package org.mu4mah.command.task;

import org.mu4mah.controller.Bootstrap;
import org.mu4mah.command.AbstractCommand;
import org.mu4mah.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskViewCommand extends AbstractCommand {

    private final String COMMAND = "tv";
    private final String DESCRIPTION = "Просмотреть детали задачи.";
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
        int idx;
        final List<Task> tasks = new ArrayList<>(bootstrap.getTaskService().findAll());
        if (tasks.size() == 0) {
            System.out.println("Список задач пуст.");
            return;
        }
        int size = tasks.size();
        for (idx = 0; idx < size; idx++) {
            System.out.println((idx + 1) + ". " + tasks.get(idx).toString());
        }
        System.out.print("Выберите номер задачи для просмотра: ");
        final int id = bootstrap.getNextInt();
        if (id > size) {
            System.out.println("Нет такой задачи.");
            return;
        }
        final String uidSelected = tasks.get(id - 1).getUid();
        System.out.println(bootstrap.getTaskService().findOne(uidSelected));
    }

    @Override
    public boolean isSecure() {
        return isSecure;
    }
}
