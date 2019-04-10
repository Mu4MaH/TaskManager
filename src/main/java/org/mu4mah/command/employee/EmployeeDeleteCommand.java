package org.mu4mah.command.employee;

import org.mu4mah.controller.Bootstrap;
import org.mu4mah.command.AbstractCommand;
import org.mu4mah.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDeleteCommand extends AbstractCommand {

    private final String COMMAND = "ed";
    private final String DESCRIPTION = "Удалить запись сотрудника.";
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
        int i;
        final List<Employee> employees = new ArrayList<>(bootstrap.getEmployeeService().findAll());
        int size = employees.size();
        for (i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + employees.get(i).toString());
        }
        System.out.print("Выберите номер удаляемого пользователя: ");
        final int id = bootstrap.getNextInt();
        final String uidSelected = employees.get(id-1).getUID();
        bootstrap.getEmployeeService().remove(uidSelected);
    }

    @Override
    public boolean isSecure() {
        return this.isSecure;
    }

}
