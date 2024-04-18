package command;

import manager.CollectionManager;
import manager.ConsoleManager;

/**
 * Команда "info".
 * Описание команды: вывести в стандартный поток вывода информацию о коллекции.
 */
public class InfoCommand implements CommandInterface {
    ConsoleManager console;
    CollectionManager manager;

    public InfoCommand(ConsoleManager console, CollectionManager manager) {
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

        console.println("Дата инициализации коллекции: " + CollectionManager.initializationTime);
        var collection = manager.getCollection();
        console.println("Тип коллекции: " + collection.getClass().getName());
        console.println("Размер коллекции: " + collection.size());
    }

    @Override
    public String toString() {
        return ": вывести в стандартный поток вывода информацию о коллекции";
    }
}
