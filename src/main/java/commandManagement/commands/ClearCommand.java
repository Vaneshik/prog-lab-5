package commandManagement.commands;

import commandManagement.CommandInterface;
import manager.CollectionManager;
import manager.Console;

public class ClearCommand implements CommandInterface {
    Console console;
    CollectionManager manager;

    public ClearCommand(Console console, CollectionManager manager) {
        this.console = console;
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 0) {
            console.printError("Команда не принимает аргументы!");
            return;
        }

        console.println("Коллекция очищена");
        manager.clear();
    }

    @Override
    public String toString() {
        return ": очистить коллекцию";
    }
}
