package command;

import manager.CollectionManager;
import manager.ConsoleManager;

/**
 * Команда "remove_by_id".
 * Описание команды: удалить элемент из коллекции по его id.
 */
public class RemoveByIdCommand implements CommandInterface {
    ConsoleManager console;
    CollectionManager manager;

    public RemoveByIdCommand(ConsoleManager console, CollectionManager manager) {
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
        return " <id> : удалить элемент из коллекции по его id";
    }
}
