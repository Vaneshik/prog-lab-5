package commandManagement.commands;

import commandManagement.CommandInterface;
import manager.CollectionManager;
import manager.Console;

public class RemoveLowerCommand implements CommandInterface {
    Console console;
    CollectionManager manager;

    public RemoveLowerCommand(Console console, CollectionManager manager) {
        this.console = console;
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            console.printError("Команда принимает один аргумент!");
            return;
        }

        console.println("Удалены элементы, меньшие, чем заданный");
//        manager.removeLower(args[0]);
    }

    @Override
    public String toString() {
        return ": удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
