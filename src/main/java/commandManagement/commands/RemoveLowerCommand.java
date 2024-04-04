package commandManagement.commands;

import commandManagement.CommandInterface;
import manager.CollectionManager;
import manager.Console;
import models.Organization;
import models.forms.OrganizationForm;

public class RemoveLowerCommand implements CommandInterface {
    Console console;
    CollectionManager manager;

    public RemoveLowerCommand(Console console, CollectionManager manager) {
        this.console = console;
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 0) {
            console.printError("Команда не принимает аргументы!");
            return;
        }

        console.println("Удалены элементы, меньшие, чем заданный");
        manager.removeLower(new OrganizationForm(console).build());
    }

    @Override
    public String toString() {
        return ": удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
