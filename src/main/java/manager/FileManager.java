package manager;

import manager.CollectionManager;
import manager.Console;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class FileManager {
    private String inputFileName;
    private Console console;
    private CollectionManager collectionManager;

    public FileManager(String inputFileName, Console console, CollectionManager collectionManager) {
        this.inputFileName = inputFileName;
        this.console = console;
        this.collectionManager = collectionManager;
    }

    public void saveCollection() throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(CollectionManager.class);
            Marshaller jaxbMarshaller = context.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(collectionManager.getCollection(), new File(inputFileName));
        } catch (JAXBException e) {
            console.printError("Ошибка сохранения коллекции :(");
        }
    }

    public void fillCollection() throws JAXBException {
        File file = new File(inputFileName);

        if (!file.exists()) {
            console.printError("Файл не найден");
            return;
        }
        if (!file.canRead()) {
            console.printError("Нет прав на чтение файла");
            return;
        }

        JAXBContext context = JAXBContext.newInstance(CollectionManager.class);
        collectionManager.setCollection(((CollectionManager) context.createUnmarshaller().unmarshal(file)).getCollection());
    }
}
