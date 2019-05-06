package org.mu4mah.command.project;

import org.mu4mah.controller.Bootstrap;
import org.mu4mah.command.AbstractCommand;
import org.mu4mah.entity.Project;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ProjectCreateCommand extends AbstractCommand {

    private final String COMMAND = "pc";
    private final String DESCRIPTION = "Создать проект.";
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
        final Project project = new Project();
        System.out.print("Введите название проекта: ");
        project.setName(bootstrap.getNextLine());
        System.out.print("Введите описание проекта: ");
        project.setDescription(bootstrap.getNextLine());
        project.setDateStart(LocalDate.now(ZoneId.of("Europe/Moscow")));
        System.out.print("Введите расчётную дату окончания проекта в виде ГГГГ-ММ-ДД: ");
        final String dateEnd = bootstrap.getNextLine();
        project.setDateEnd(LocalDate.parse(dateEnd));
        bootstrap.getProjectService().persist(project);
    }

    @Override
    public boolean isSecure() {
        return this.isSecure;
    }

}
