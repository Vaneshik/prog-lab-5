package command;

import manager.CommandManager;
import manager.ConsoleManager;

/**
 * Команда "help".
 * Описание команды: вывести справку по доступным командам.
 */
public class HelpCommand implements CommandInterface {
    ConsoleManager console;
    CommandManager manager;

    public HelpCommand(ConsoleManager console, CommandManager manager) {
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

        console.println("Доступные команды:");
        manager.getCommands().forEach((name, command) -> console.println(name + command.toString()));
    }

    @Override
    public String toString() {
        return ": вывести справку по доступным командам";
    }
}
