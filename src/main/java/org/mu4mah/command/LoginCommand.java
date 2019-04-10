package org.mu4mah.command;


import org.mu4mah.controller.Bootstrap;

public class LoginCommand extends AbstractCommand {

    private final String COMMAND = "login";
    private final String DESCRIPTION = "Войти в систему.";
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

    }

    @Override
    public boolean isSecure() {
        return isSecure;
    }

}

