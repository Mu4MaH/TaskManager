package org.mu4mah.controller;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mu4mah.command.AbstractCommand;
import org.mu4mah.command.HelpCommand;
import org.mu4mah.command.LoginCommand;
import org.mu4mah.command.QuitCommand;
import org.mu4mah.command.data.DataLoadFromJsonCommand;
import org.mu4mah.command.data.DataSaveToJsonCommand;
import org.mu4mah.command.project.*;
import org.mu4mah.command.task.*;
import org.mu4mah.command.employee.*;
import org.mu4mah.entity.Domain;
import org.mu4mah.entity.Employee;
import org.mu4mah.service.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bootstrap {

    private final static Class[] COMMANDS = {EmployeeAssignTaskCommand.class, EmployeeCreateCommand.class, EmployeeDeleteCommand.class, EmployeeEditCommand.class, EmployeeViewCommand.class, EmployeeViewAllCommand.class,
            ProjectCreateCommand.class, ProjectDeleteCommand.class, ProjectEditCommand.class, ProjectViewCommand.class, ProjectViewAllCommand.class,
            TaskCreateCommand.class, TaskDeleteCommand.class, TaskEditCommand.class, TaskViewCommand.class, TaskAddToProjectCommand.class, TaskViewAllCommand.class,
            DataLoadFromJsonCommand.class, DataSaveToJsonCommand.class,
            HelpCommand.class, LoginCommand.class, QuitCommand.class};

    @Getter
    private final Map<String, AbstractCommand> commandMap = new HashMap<>();

    @Getter
    private TaskService taskService = new TaskService();

    @Getter
    private ProjectService projectService = new ProjectService();

    @Getter
    private EmployeeService employeeService = new EmployeeService();

    @Getter
    private AssigneeService assigneeService = new AssigneeService();

    @Getter
    private final Domain domain = new Domain();

    private final Scanner scanner = new Scanner(System.in);

    {
        /* Built-in Administrator account creating */

        final Employee admin = new Employee();
        admin.setRole("admin");
        admin.setLogin("admin");
        admin.setName("Одмен");
        admin.setPassword("admin");
        employeeService.persist(admin);

        /*    ***     */
    }



    @NotNull
    public String getNextLine() {
        return scanner.nextLine();
    }

    @NotNull
    public Integer getNextInt() {
        final String input;
        final int output;
        input = scanner.nextLine();
        try {
            output = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Введите число!");
            return getNextInt();
        }
        return output;
    }

    public void init() throws Exception {
        AbstractCommand claz;
        for (Class c : COMMANDS) {
            claz = (AbstractCommand) c.newInstance();
            commandMap.put(claz.getCommand(), claz);
        }
        System.out.println(" -= Добро пожаловать в консоль управления задачами =-\n");
        System.out.println("Список команд:");
        for (AbstractCommand c : commandMap.values()) {
            System.out.println(c.getCommand() + " - " + c.getDescription());
        }
        while (true) {
            System.out.print("Введите команду> ");
            final String cmd = scanner.nextLine();
            if (!commandMap.containsKey(cmd)) ;
            else {
                commandMap.get(cmd).execute(this);
            }
        }
    }

}
