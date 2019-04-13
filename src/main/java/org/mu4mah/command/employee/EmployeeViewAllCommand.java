package org.mu4mah.command.employee;

import org.mu4mah.command.AbstractCommand;
import org.mu4mah.controller.Bootstrap;
import org.mu4mah.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeViewAllCommand extends AbstractCommand {

    private final String COMMAND = "eva";
    private final String DESCRIPTION = "Просмотреть список всех работников";
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
        int idx = 0;
        final List<Employee> employees = new ArrayList<>(bootstrap.getEmployeeService().findAll());
        if (employees.size() == 0) {
            System.out.println("Список пользователей пуст.");
            return;
        }
        for (Employee e : employees) {
            System.out.println(idx++ + e.toString());
        }
    }

    @Override
    public boolean isSecure() {
        return this.isSecure;
    }
}
