package commandManagement.commands;

import commandManagement.CommandInterface;
import manager.CollectionManager;
import manager.Console;
import models.Organization;
import models.forms.AddressForm;

public class FilterLessThanPostalAddressCommand implements CommandInterface {
    Console console;
    CollectionManager manager;

    public FilterLessThanPostalAddressCommand(Console console, CollectionManager manager) {
        this.console = console;
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 0) {
            console.printError("Команда не принимает аргументы!");
            return;
        }

        var response = manager.filterLessThanPostalAddress(new AddressForm(console).build());
        if (response.isEmpty()) {
            console.println("Элементов не найдено");
        } else {
            console.println("Элементы, значение поля postalAddress которых меньше заданного:");
            response.stream().map(Organization::toString).forEach(console::println);
        }
    }

    @Override
    public String toString() {
        return ": вывести элементы, значение поля postalAddress которых меньше заданного";
    }
}
