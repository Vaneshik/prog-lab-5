package commandManagement.commands;

import commandManagement.CommandInterface;
import manager.Console;
import manager.FileManager;

import javax.xml.bind.JAXBException;

public class SaveCommand implements CommandInterface {
    FileManager fileManager;
    Console console;

    public SaveCommand(Console console, FileManager fileManager) {
        this.fileManager = fileManager;
        this.console = console;
    }

    @Override
    public void execute(String[] args) throws JAXBException {
        fileManager.saveCollection();
        console.println("Коллекция сохранена в файл");
    }

    @Override
    public String toString() {
        return ": сохранить коллекцию в файл";
    }
}
