package commandManagement.commands;

import commandManagement.CommandInterface;
import manager.CollectionManager;
import manager.Console;

public class FilterContainsNameCommand implements CommandInterface {
    Console console;
    CollectionManager manager;

    public FilterContainsNameCommand(Console console, CollectionManager manager) {
        this.console = console;
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            console.printError("Команда принимает один аргумент!");
            return;
        }
        var filteredOrganizations = manager.filterContainsName(args[0]);
        if (!filteredOrganizations.isEmpty()) {
            console.println("Элементы, значение поля name которых содержит заданную подстроку:");
            filteredOrganizations.stream().map(Object::toString).forEach(console::println);
        } else {
            console.println("Ничего не найдено! :(");
        }
    }

    @Override
    public String toString() {
        return ": вывести элементы, значение поля name которых содержит заданную подстроку";
    }
}
