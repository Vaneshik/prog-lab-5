package commandManagement.commands;

import commandManagement.CommandInterface;

public class SaveCommand implements CommandInterface {
    @Override
    public void execute(String[] args) {
    }

    @Override
    public String toString() {
        return ": сохранить коллекцию в файл";
    }
}
