package commandManagement.commands;

import commandManagement.CommandInterface;
import manager.CommandManager;
import manager.Console;

public class HelpCommand implements CommandInterface {
    Console console;
    CommandManager manager;

    public HelpCommand(Console console, CommandManager manager) {
        this.console = console;
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 0) {
            console.printError("Команда не принимает аргументы!");
            return;
        }

        console.println("Доступные команды:");
        manager.getCommands().forEach((name, command) -> console.println(name + command.toString()));
    }

    @Override
    public String toString() {
        return ": вывести справку по доступным командам";
    }
}
