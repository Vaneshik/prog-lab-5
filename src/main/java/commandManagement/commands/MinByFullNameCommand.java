package commandManagement.commands;

import commandManagement.CommandInterface;
import manager.CollectionManager;
import manager.Console;

public class MinByFullNameCommand implements CommandInterface {
    Console console;
    CollectionManager manager;

    public MinByFullNameCommand(Console console, CollectionManager manager) {
        this.console = console;
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 0) {
            console.printError("Команда не принимает аргументы!");
            return;
        }
        console.println("Элемент с минимальным значением поля fullName:");
        console.println(manager.minByFullName());
    }

    @Override
    public String toString() {
        return ": вывести любой объект из коллекции, значение поля fullName которого является минимальным";
    }
}
