package org.mu4mah.command.employee;

import org.mu4mah.api.entity.AbstractEntity;
import org.mu4mah.controller.Bootstrap;
import org.mu4mah.command.AbstractCommand;
import org.mu4mah.entity.Employee;
import org.mu4mah.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAssignTaskCommand extends AbstractCommand {

    private final String COMMAND = "ea";
    private final String DESCRIPTION = "Назначить работника на проект.";
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
        int idx = 1;
        final List<AbstractEntity> employees = new ArrayList<>(bootstrap.getEmployeeService().findAll());
        int size = employees.size();
        if (size == 0) {
            System.out.println("Список пользователей пуст.");
            return;
        }
        final List<AbstractEntity> tasks = new ArrayList<>(bootstrap.getTaskService().findAll());
        if (tasks.size() == 0) {
            System.out.println("Список задач пуст.");
            return;
        }
        for (AbstractEntity e : employees) {
            System.out.println(idx++ + ". " + e.toString());
        }
        System.out.println("Выберите пользователя для создание назначения");
        int id = bootstrap.getNextInt();
        if (id > size) {
            System.out.println("Нет такого пользователя.");
            return;
        }
        final String employeeId = employees.get(id-1).getUID();
        size = tasks.size();
        idx = 1;
        for (AbstractEntity t: tasks) {
            System.out.println(idx++ + ". " + t.toString());
        }
        System.out.print("Выберите номер задачи назначения: ");
        id = bootstrap.getNextInt();
        if (id > size) {
            System.out.println("Нет такой задачи.");
            return;
        }
        final String taskId = tasks.get(id-1).getUID();

        System.out.println("DEBUG:::::: " + employeeId + " - " + taskId);
        bootstrap.getAssigneeService().persist(employeeId, taskId);
    }

    @Override
    public boolean isSecure() {
        return this.isSecure;
    }
}
