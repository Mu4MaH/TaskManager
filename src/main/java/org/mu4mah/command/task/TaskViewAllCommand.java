package org.mu4mah.command.task;

import org.mu4mah.command.AbstractCommand;
import org.mu4mah.controller.Bootstrap;
import org.mu4mah.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskViewAllCommand extends AbstractCommand {

    private final String COMMAND = "tva";
    private final String DESCRIPTION = "Вывести на экран список всех задач";
    private boolean isSecure = true;

    @Override
    public String getCommand() {
        return COMMAND;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public void execute(Bootstrap bootstrap) throws Exception {
        int idx;
        final List<Task> tasks = new ArrayList<>(bootstrap.getTaskService().findAll());
        if (tasks.size() == 0) {
            System.out.println("Список задач пуст.");
            return;
        }
        int size = tasks.size();
        for (idx = 0; idx < size; idx++ ){
            System.out.println((idx + 1) + ". " + tasks.get(idx).toString());
        }
    }

    @Override
    public boolean isSecure() {
        return isSecure;
    }
}
