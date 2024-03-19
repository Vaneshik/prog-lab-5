package commandManagement.commands;

import commandManagement.CommandInterface;
import manager.Console;


public class ExitCommand implements CommandInterface {
    Console console;

    public ExitCommand(Console console) {
        this.console = console;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 0) {
            console.printError("Команда не принимает аргументы!");
            return;
        }

        console.println("Завершаю программу! (без сохранения в файл)");
        System.exit(0);
    }

    @Override
    public String toString() {
        return ": завершить программу (без сохранения в файл)";
    }
}
