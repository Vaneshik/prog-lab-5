package commandManagement.commands;

import commandManagement.CommandInterface;
import manager.CollectionManager;
import manager.Console;

public class AddCommand implements CommandInterface {
    Console console;
    CollectionManager manager;

    public AddCommand(Console console, CollectionManager manager){
        this.console = console;
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 0){
            console.printError("Команда не принимает аргументы!");
            return;
        }

        // TODO: Parse input

        // manager.add();
    }

    @Override
    public String toString() {
        return ": добавить новый элемент в коллекцию";
    }
}
