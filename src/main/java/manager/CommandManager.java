package manager;

import commandManagement.CommandInterface;

import javax.xml.bind.JAXBException;
import java.util.HashMap;

public class CommandManager {
    HashMap<String, CommandInterface> commands = new HashMap<>();
    Console console;

    public CommandManager(Console console) {
        this.console = console;
    }

    public HashMap<String, CommandInterface> getCommands() {
        return commands;
    }

    public void setCommands(HashMap<String, CommandInterface> commands) {
        this.commands = commands;
    }

    public void addCommand(String name, CommandInterface command) {
        commands.put(name, command);
    }

    public void executeCommand(String name, String[] args) throws JAXBException {
        CommandInterface command = commands.get(name);
        if (command != null) {
            command.execute(args);
        } else {
            console.println("Команда не найдена! Попробуйте ввести 'help' для получения списка команд.");
        }
    }
}
