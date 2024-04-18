package command;

import manager.ConsoleManager;
import manager.FileManager;

/**
 * Команда "save".
 * Описание команды: сохранить коллекцию в файл.
 */
public class SaveCommand implements CommandInterface {
    FileManager fileManager;
    ConsoleManager console;

    public SaveCommand(ConsoleManager console, FileManager fileManager) {
        this.fileManager = fileManager;
        this.console = console;
    }

    /**
     * Выполнение команды.
     *
     * @param args аргументы
     */
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
