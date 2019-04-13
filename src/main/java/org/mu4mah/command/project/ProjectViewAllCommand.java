package org.mu4mah.command.project;

import org.mu4mah.command.AbstractCommand;
import org.mu4mah.controller.Bootstrap;
import org.mu4mah.entity.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectViewAllCommand extends AbstractCommand {

    private final String COMMAND = "pva";
    private final String DESCRIPTION = "Вывести на экран список всех проектов.";
    private final boolean isSecure = true;

    @Override
    public void execute(Bootstrap bootstrap) throws Exception {
        int idx;
        final List<Project> projects = new ArrayList<>(bootstrap.getProjectService().findAll());
        if (projects.size() == 0) {
            System.out.println("Список проектов пуст");
            return;
        }
        int size = projects.size();
        for (idx = 0; idx < size; idx++) {
            System.out.println((idx + 1) + ". " + projects.get(idx).toString());
        }
    }

    @Override
    public String getCommand() {
        return COMMAND;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public boolean isSecure() {
        return isSecure;
    }
}
