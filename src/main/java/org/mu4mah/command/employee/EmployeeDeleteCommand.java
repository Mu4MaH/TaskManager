package org.mu4mah.command.employee;

import org.mu4mah.api.entity.AbstractEntity;
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
        int idx;
        final List<AbstractEntity> employees = new ArrayList<>(bootstrap.getEmployeeService().findAll());
        if (employees.size() == 0 ) {
            System.out.println("Список работников пуст.");
            return;
        }
        int size = employees.size();
        for (idx = 0; idx < size; idx++) {
            System.out.println((idx + 1) + ". " + employees.get(idx).toString());
        }
        System.out.print("Выберите номер удаляемого пользователя: ");
        final int id = bootstrap.getNextInt();
        if (id > size) {
            System.out.println("Нет такого пользователя.");
            return;
        }
        final String uidSelected = employees.get(id-1).getUID();
        bootstrap.getEmployeeService().remove(uidSelected);
    }

    @Override
    public boolean isSecure() {
        return this.isSecure;
    }

}
