//але але ванешик жопа привет от кати пим на перекур то когда пойдем жду на 11п балконе
package commandManagement.commands;

import commandManagement.CommandInterface;
import manager.CollectionManager;
import manager.Console;

public class ShowCommand implements CommandInterface {
    Console console;
    CollectionManager manager;

    public ShowCommand(Console console, CollectionManager manager) {
        this.console = console;
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 0) {
            console.printError("Команда не принимает аргументы!");
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
