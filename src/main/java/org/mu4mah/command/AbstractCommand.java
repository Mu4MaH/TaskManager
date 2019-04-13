package org.mu4mah.command;

import org.mu4mah.controller.Bootstrap;

public abstract class AbstractCommand {

    public abstract String getCommand();

    public abstract String getDescription();

    public abstract void execute(Bootstrap bootstrap) throws Exception;

    public abstract boolean isSecure();

}