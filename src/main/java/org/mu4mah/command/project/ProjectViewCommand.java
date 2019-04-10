package org.mu4mah.command.project;

import org.mu4mah.command.AbstractCommand;
import org.mu4mah.controller.Bootstrap;

public class ProjectViewCommand extends AbstractCommand {

    private final String COMMAND = "pv";
    private final String DESCRIPTION = "Просмотреть детали проекта.";
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

    }

    @Override
    public boolean isSecure() {
        return isSecure;
    }

}
