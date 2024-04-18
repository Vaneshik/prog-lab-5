package command;

import manager.CollectionManager;
import manager.ConsoleManager;

/**
 * Команда "clear".
 * Описание команды: очистить коллекцию.
 */
public class ClearCommand implements CommandInterface {
    ConsoleManager console;
    CollectionManager manager;

    public ClearCommand(ConsoleManager console, CollectionManager manager) {
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

        console.println("Коллекция очищена");
        manager.clear();
    }

    @Override
    public String toString() {
        return ": очистить коллекцию";
    }
}
