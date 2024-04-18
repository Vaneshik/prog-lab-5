package command;

import manager.CollectionManager;
import manager.ConsoleManager;
import models.forms.OrganizationForm;

/**
 * Команда "update".
 * Описание команды: обновить значение элемента коллекции, id которого равен заданному.
 */
public class UpdateCommand implements CommandInterface {
    ConsoleManager console;
    CollectionManager manager;

    public UpdateCommand(ConsoleManager console, CollectionManager manager) {
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
        if (!args[0].matches("\\d+")) {
            console.printError("id должен быть числом!");
            return;
        }
        long id = Long.parseLong(args[0]);
        if (manager.getById(id) == null) {
            console.printError("Элемента с таким id нет в коллекции!");
            return;
        }
        manager.update(id, new OrganizationForm(console).build());
        console.println("Обновлен элемент с id " + args[0]);
    }

    @Override
    public String toString() {
        return " <id> : обновить значение элемента коллекции, id которого равен заданному";
    }
}
