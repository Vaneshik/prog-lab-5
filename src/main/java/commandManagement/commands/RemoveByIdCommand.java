package commandManagement.commands;

import commandManagement.CommandInterface;
import manager.CollectionManager;
import manager.Console;

public class RemoveByIdCommand implements CommandInterface {
    Console console;
    CollectionManager manager;

    public RemoveByIdCommand(Console console, CollectionManager manager) {
        this.console = console;
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            console.printError("Команда принимает один аргумент!");
            return;
        }

        try {
            long id = Long.parseLong(args[0]);
            console.println("Элемент с id " + id + " удален");
            manager.removeById(id);
        } catch (NumberFormatException e) {
            console.printError("Неверный формат аргумента!");
        }
    }

    @Override
    public String toString() {
        return ": удалить элемент из коллекции по его id";
    }
}
