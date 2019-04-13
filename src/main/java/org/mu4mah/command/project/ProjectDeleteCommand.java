package org.mu4mah.command.project;

import org.mu4mah.controller.Bootstrap;
import org.mu4mah.command.AbstractCommand;
import org.mu4mah.entity.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectDeleteCommand extends AbstractCommand {

    private final String COMMAND = "pd";
    private final String DESCRIPTION = "Удалить проект.";
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
        final List<Project> projects = new ArrayList<>(bootstrap.getProjectService().findAll());
        if (projects.size() == 0) {
            System.out.println("Список проектов пуст");
            return;
        }
        int size = projects.size();
        for (idx = 0; idx < size; idx++ ){
            System.out.println((idx + 1) + ". " + projects.get(idx).toString());
        }
        System.out.print("Выберите номер удаляемого проекта: ");
        final int id = bootstrap.getNextInt();
        if (id > size) {
            System.out.println("Нет такого проекта.");
            return;
        }
        final String uidSelected = projects.get(id-1).getUid();
        bootstrap.getProjectService().remove(uidSelected);
    }

    @Override
    public boolean isSecure() {
        return this.isSecure;
    }

}
