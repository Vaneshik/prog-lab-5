package command;

import manager.CollectionManager;
import manager.ConsoleManager;

/**
 * Команда "show".
 * Описание команды: вывести в стандартный поток вывода все элементы коллекции в строковом представлении.
 */
public class ShowCommand implements CommandInterface {
    ConsoleManager console;
    CollectionManager manager;

    public ShowCommand(ConsoleManager console, CollectionManager manager) {
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
        var collection = manager.getCollection();

        if (collection.isEmpty()) {
            console.println("Коллекция пуста!");
            return;
        }

        console.println("Элементы коллекции:");
        manager.getCollection().stream().map(Object::toString).forEach(console::println);
    }

    @Override
    public String toString() {
        return ": вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
