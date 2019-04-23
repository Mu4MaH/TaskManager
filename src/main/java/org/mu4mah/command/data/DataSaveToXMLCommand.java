package org.mu4mah.command.data;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.mu4mah.command.AbstractCommand;
import org.mu4mah.controller.Bootstrap;
import org.mu4mah.entity.Domain;

import java.io.File;
import java.io.FileWriter;

public class DataSaveToXMLCommand extends AbstractCommand {

    private final String COMMAND = ">xml";
    private final String DESCRIPTION = "Экспорт данных в xml формате в файл";

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
        final XmlMapper mapper = new XmlMapper();
        final File file = new File("./data.xml");
        if (!file.exists()) file.createNewFile();
        final FileWriter fw = new FileWriter(file);
        final Domain domain = bootstrap.getDomain().createDomain(bootstrap);
        final ToXmlGenerator generator = mapper.getFactory().createGenerator(fw);
        generator.writeObject(domain);
        generator.close();
        fw.close();
    }

    @Override
    public boolean isSecure() {
        return false;
    }

}
