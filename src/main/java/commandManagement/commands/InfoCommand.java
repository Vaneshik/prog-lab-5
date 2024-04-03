package commandManagement.commands;

import commandManagement.CommandInterface;
import manager.CollectionManager;
import manager.CommandManager;
import manager.Console;

// вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
public class InfoCommand implements CommandInterface {
    Console console;
    CollectionManager manager;

    public InfoCommand(Console console, CollectionManager manager) {
        this.console = console;
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 0) {
            console.printError("Команда не принимает аргументы!");
            return;
        }

        console.println("Дата инициализации коллекции: " + CollectionManager.initializationTime);
        var collection = manager.getCollection();
        console.println("Тип коллекции: " + collection.getClass().getName());
        console.println("Размер коллекции: " + collection.size());
    }

    @Override
    public String toString() {
        return ": вывести в стандартный поток вывода информацию о коллекции";
    }
}
