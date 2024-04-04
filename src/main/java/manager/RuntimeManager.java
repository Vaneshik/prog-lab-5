package manager;

import java.util.Arrays;
import java.util.Scanner;

public class RuntimeManager {
    FileManager fileManager;
    CommandManager commandManager;
    Console console;

    public RuntimeManager(Console console, FileManager fileManager, CommandManager commandManager) {
        this.fileManager = fileManager;
        this.commandManager = commandManager;
        this.console = console;
    }

    public void interactiveMode() {
        Scanner scanner = new Scanner(System.in);
        fileManager.fillCollection();
        while (true) {
            console.print(">>> ");
            String[] userCommand = scanner.nextLine().trim().split(" ");
            commandManager.executeCommand(userCommand[0], Arrays.copyOfRange(userCommand, 1, userCommand.length));
        }
    }
}
