package commandManagement.commands;

import commandManagement.CommandInterface;
import manager.CollectionManager;
import manager.Console;
import models.Organization;
import models.forms.OrganizationForm;

public class UpdateCommand implements CommandInterface {
    Console console;
    CollectionManager manager;

    public UpdateCommand(Console console, CollectionManager manager) {
        this.console = console;
        this.manager = manager;
    }

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
        return ": обновить значение элемента коллекции, id которого равен заданному";
    }
}
