package org.mu4mah.command.employee;

import org.mu4mah.controller.Bootstrap;
import org.mu4mah.command.AbstractCommand;
import org.mu4mah.entity.Employee;

public class EmployeeCreateCommand extends AbstractCommand {

    private final String COMMAND = "ec";
    private final String DESCRIPTION = "Создать запись сотрудника.";
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
        final Employee employee = new Employee();
        System.out.print("Введите имя работника: ");
        employee.setName(bootstrap.getNextLine());
        System.out.print("Введите логин пользователя: ");
        employee.setLogin(bootstrap.getNextLine());
        System.out.print("Введите пароль пользователя: ");
        employee.setPassword(String.valueOf(bootstrap.getNextLine().hashCode()));
        employee.setRole("user");
        bootstrap.getEmployeeService().persist(employee);
    }

    @Override
    public boolean isSecure() {
        return this.isSecure;
    }


}
