package commandManagement.commands;

import commandManagement.CommandInterface;
import manager.CollectionManager;
import manager.Console;

public class RemoveGreaterCommand implements CommandInterface {
    Console console;
    CollectionManager manager;

    public RemoveGreaterCommand(Console console, CollectionManager manager) {
        this.console = console;
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            console.printError("Команда принимает один аргумент!");
            return;
        }

        console.println("Удалены элементы, превышающие заданный");
        // TODO: parse input
        // manager.removeGreater(args[0]);
    }

    @Override
    public String toString() {
        return ": удалить из коллекции все элементы, превышающие заданный";
    }
}
