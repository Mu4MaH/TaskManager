package org.mu4mah.command.task;

import org.mu4mah.controller.Bootstrap;
import org.mu4mah.command.AbstractCommand;

public class TaskCreateCommand extends AbstractCommand {

    private final String COMMAND = "tc";
    private final String DESCRIPTION = "Создать задачу";
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
