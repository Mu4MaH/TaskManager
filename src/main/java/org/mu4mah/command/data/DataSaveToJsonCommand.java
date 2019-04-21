package org.mu4mah.command.data;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mu4mah.command.AbstractCommand;
import org.mu4mah.controller.Bootstrap;
import org.mu4mah.entity.Domain;

import java.io.File;
import java.io.FileWriter;

public class DataSaveToJsonCommand extends AbstractCommand {

    private final String COMMAND = ">json";
    private final String DESCRIPTION = "Экспорт данных в json формате.";

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
        final File file;
        file = new File("./data.json");
        if (!file.exists()) file.createNewFile();
        final ObjectMapper mapper = new ObjectMapper();
        final FileWriter fileWriter = new FileWriter(file);
        final Domain domain = bootstrap.getDomain().createDomain(bootstrap);
        JsonGenerator jsonGenerator = mapper.getFactory().createGenerator(fileWriter);
        jsonGenerator.writeObject(domain);
        jsonGenerator.close();
        fileWriter.close();
    }

    @Override
    public boolean isSecure() {
        return false;
    }
}
