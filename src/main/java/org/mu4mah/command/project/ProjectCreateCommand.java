package org.mu4mah.command.project;

import org.mu4mah.controller.Bootstrap;
import org.mu4mah.command.AbstractCommand;

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

    }

    @Override
    public boolean isSecure() {
        return this.isSecure;
    }

}
