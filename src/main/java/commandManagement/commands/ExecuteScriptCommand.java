package commandManagement.commands;

import commandManagement.CommandInterface;

public class ExecuteScriptCommand implements CommandInterface {
    @Override
    public void execute(String[] args) {
    }

    @Override
    public String toString() {
        return ": считать и исполнить скрипт из указанного файла";
    }
}
