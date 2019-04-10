package org.mu4mah.command;

import org.mu4mah.controller.Bootstrap;

public class QuitCommand extends AbstractCommand {

    private final String COMMAND = "quit";
    private final String DESCRIPTION = "Выйти из приложения.";
    private final boolean isSecure = false;

    @Override
    public String getCommand() {
        return COMMAND;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public void execute(Bootstrap bootstrap) throws Exception {
        System.exit(0);
    }

    @Override
    public boolean isSecure() {
        return isSecure;
    }

}
