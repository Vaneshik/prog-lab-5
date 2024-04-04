package manager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import manager.CollectionManager;
import manager.Console;
import models.*;

import java.io.*;
import java.util.Date;
import java.util.TreeSet;

public class FileManager {
    private String inputFileName;
    private Console console;
    private CollectionManager collectionManager;

    public FileManager(String inputFileName, Console console, CollectionManager collectionManager) {
        this.inputFileName = inputFileName;
        this.console = console;
        this.collectionManager = collectionManager;
    }

    public void saveCollection() throws JsonProcessingException {
        try {
            XmlMapper mapper = new XmlMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(inputFileName), collectionManager.getCollection());
        } catch (Exception e) {
            console.printError("Ошибка сохранения коллекции в файл");
        }
    }

    public void fillCollection() {
        File file = new File(inputFileName);
        if (!file.exists()) {
            console.printError("Файл не найден");
            return;
        }
        if (!file.canRead()) {
            console.printError("Нет прав на чтение файла");
            return;
        }
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JavaTimeModule());
            String xml = inputStreamToString(new FileInputStream(file));
            collectionManager.setCollection(xmlMapper.readValue(xml, new TypeReference<TreeSet<Organization>>() {}));
//            collectionManager.add(new Organization(98, "meow3 but freak", new Coordinates(1d, 1f), new Date(), 1d, "A Totally Freak Freak", 125, OrganizationType.COMMERCIAL, new Address("9843483", new Location(1L, 1d, "town1"))));
        } catch (Exception e) {
            console.printError(e.getMessage());
            console.printError("Ошибка чтения файла");
        }
    }

    public String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}
