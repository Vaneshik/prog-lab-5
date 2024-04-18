package command;

import manager.CollectionManager;
import manager.ConsoleManager;
import models.forms.OrganizationForm;

/**
 * Команда "remove_greater".
 * Описание команды: удалить из коллекции все элементы, превышающие заданный.
 */
public class RemoveGreaterCommand implements CommandInterface {
    ConsoleManager console;
    CollectionManager manager;

    public RemoveGreaterCommand(ConsoleManager console, CollectionManager manager) {
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

        console.println("Удалены элементы, превышающие заданный");
        manager.removeGreater(new OrganizationForm(console).build());
    }

    @Override
    public String toString() {
        return ": удалить из коллекции все элементы, превышающие заданный";
    }
}
