package org.mu4mah.command;


import org.mu4mah.controller.Bootstrap;

public class HelpCommand extends AbstractCommand {

    private final String COMMAND = "help";
    private final String DESCRIPTION = "Справка по командам.";
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
        System.out.println("Список команд:");
        for (AbstractCommand c : bootstrap.getCommandMap().values()) {
            System.out.println(c.getCommand() + " - " + c.getDescription());
        }
    }

    @Override
    public boolean isSecure() {
        return isSecure;
    }

}
