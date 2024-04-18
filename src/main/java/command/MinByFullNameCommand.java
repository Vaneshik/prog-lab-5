package command;

import manager.CollectionManager;
import manager.ConsoleManager;

/**
 * Команда "min_by_full_name".
 * Описание команды: вывести любой объект из коллекции, значение поля fullName которого является минимальным.
 */
public class MinByFullNameCommand implements CommandInterface {
    ConsoleManager console;
    CollectionManager manager;

    public MinByFullNameCommand(ConsoleManager console, CollectionManager manager) {
        this.console = console;
        this.manager = manager;
    }

    /**
     * Выполнение команды.
     *
     * @param args аргументы
     */
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
