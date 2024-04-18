package command;

import manager.CommandManager;
import manager.ConsoleManager;
import manager.FileManager;
import manager.ScriptManager;

import java.io.File;
import java.util.Arrays;

/**
 * Команда "execute_script".
 * Описание команды: считать и исполнить скрипт из указанного файла.
 */
public class ExecuteScriptCommand implements CommandInterface {
    ConsoleManager console;
    CommandManager commandManager;

    public ExecuteScriptCommand(ConsoleManager console, CommandManager commandManager) {
        this.console = console;
        this.commandManager = commandManager;
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

        String filename = args[0];

        File file = new File(filename);

        if (!FileManager.canRead(file, console)) {
            return;
        }

        try {
            ScriptManager.addFile(filename);
            String line;

            while (!(line = ScriptManager.nextLine()).isEmpty()) {
                String[] command = line.trim().split(" ");
                if (command[0].equalsIgnoreCase("execute_script") && ScriptManager.isRecursive(command[1])) {
                    console.printError("Найдена рекурсия! Повторно вызывается файл " +
                            new File(command[1]).getAbsolutePath());
                    continue;
                }

                console.println("Выполнение команды " + command[0] + ":");
                if (commandManager.getCommands().get(command[0]) != null) {
                    commandManager.executeCommand(command[0], Arrays.copyOfRange(command, 1, command.length));
                } else {
                    console.printError("Такой команды нет!((");
                }
            }
            ScriptManager.removeFile();
        } catch (Exception e) {
            console.printError(e.getMessage());
        }
    }


    @Override
    public String toString() {
        return " <filename> : считать и исполнить скрипт из указанного файла";
    }
}
