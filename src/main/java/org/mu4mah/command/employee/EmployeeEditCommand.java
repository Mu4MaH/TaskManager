package org.mu4mah.command.employee;

import org.mu4mah.controller.Bootstrap;
import org.mu4mah.command.AbstractCommand;

public class EmployeeEditCommand extends AbstractCommand {

    private final String COMMAND = "ee";
    private final String DESCRIPTION = "Редактировать запись сотрудника.";
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
//TODO реализацию редактирования продумать
    }

    @Override
    public boolean isSecure() {
        return this.isSecure;
    }

}
