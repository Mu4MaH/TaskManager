package org.mu4mah.command.data;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.mu4mah.command.AbstractCommand;
import org.mu4mah.controller.Bootstrap;
import org.mu4mah.entity.Domain;

import java.io.File;
import java.io.FileReader;

public class DataLoadFromXMLCommand extends AbstractCommand {

    private final String COMMAND = "<xml";
    private final String DESCRIPTION = "Импорт данных их xml формата.";

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
        final File file = new File("./data.xml");
        final XmlMapper mapper = new XmlMapper();
        FileReader fr = new FileReader(file);
        final Domain domain = mapper.readValue(fr, Domain.class);
        bootstrap.getDomain().loadDomain(bootstrap, domain);
    }

    @Override
    public boolean isSecure() {
        return true;
    }
}
