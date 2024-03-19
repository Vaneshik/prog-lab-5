package commandManagement.commands;

import commandManagement.CommandInterface;
import manager.CollectionManager;
import manager.Console;

public class FilterLessThanPostalAddressCommand implements CommandInterface {
    Console console;
    CollectionManager manager;

    public FilterLessThanPostalAddressCommand(Console console, CollectionManager manager) {
        this.console = console;
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            console.printError("Команда принимает один аргумент!");
            return;
        }

        // TODO: Parse input

//        manager.filterLessThanPostalAddress(args[0]);
    }

    @Override
    public String toString() {
        return ": вывести элементы, значение поля postalAddress которых меньше заданного";
    }
}
