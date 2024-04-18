package command;

import manager.CollectionManager;
import manager.ConsoleManager;
import models.forms.OrganizationForm;

/**
 * Команда "add_if_min".
 * Описание команды: добавить новый элемент, если его значение меньше, чем у наименьшего элемента коллекции.
 */
public class AddIfMinCommand implements CommandInterface {
    ConsoleManager console;
    CollectionManager manager;

    public AddIfMinCommand(ConsoleManager console, CollectionManager manager) {
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

        manager.addIfMin(new OrganizationForm(console).build());
        console.println("Элемент добавлен!");
    }

    @Override
    public String toString() {
        return ": добавить новый элемент, если его значение меньше, чем у наименьшего элемента коллекции";
    }
}
