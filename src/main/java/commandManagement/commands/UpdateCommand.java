package commandManagement.commands;

import commandManagement.CommandInterface;
import manager.CollectionManager;
import manager.Console;

public class UpdateCommand implements CommandInterface {
    Console console;
    CollectionManager manager;

    public UpdateCommand(Console console, CollectionManager manager) {
        this.console = console;
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            console.printError("Команда принимает два аргумента!");
            return;
        }

        console.println("Обновлен элемент с id " + args[0]);
        // TODO: parse input
//        manager.update(args[1]);
    }

    @Override
    public String toString() {
        return ": обновить значение элемента коллекции, id которого равен заданному";
    }
}
