package org.mu4mah.command.data;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mu4mah.command.AbstractCommand;
import org.mu4mah.controller.Bootstrap;
import org.mu4mah.entity.Domain;

import java.io.File;
import java.io.FileWriter;

public class DataLoadFromJsonCommand extends AbstractCommand {

    private final String COMMAND = "<json";
    private final String DESCRIPTION = "Импорт данных из json формата.";

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
        final File file = new File("./data.json");
        final ObjectMapper mapper = new ObjectMapper();
        final Domain domain = mapper.getFactory().createParser(file).readValueAs(Domain.class);
        bootstrap.getDomain().loadDomain(bootstrap, domain);
    }

    @Override
    public boolean isSecure() {
        return false;
    }
}
