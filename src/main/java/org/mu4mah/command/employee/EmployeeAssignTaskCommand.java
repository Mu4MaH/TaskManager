package org.mu4mah.command.employee;

import org.mu4mah.controller.Bootstrap;
import org.mu4mah.command.AbstractCommand;

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
//TODO
    }

    @Override
    public boolean isSecure() {
        return this.isSecure;
    }
}
