package commandManagement.commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import commandManagement.CommandInterface;
import manager.Console;
import manager.FileManager;

public class SaveCommand implements CommandInterface {
    FileManager fileManager;
    Console console;

    public SaveCommand(Console console, FileManager fileManager) {
        this.fileManager = fileManager;
        this.console = console;
    }

    @Override
    public void execute(String[] args)  {
        try {
            fileManager.saveCollection();
        } catch (Exception e){
            console.printError(e.getMessage());
        }
        console.println("Коллекция сохранена в файл");
    }

    @Override
    public String toString() {
        return ": сохранить коллекцию в файл";
    }
}
