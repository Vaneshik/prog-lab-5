import commandManagement.commands.*;
import manager.*;


public class Main {
    public static void main(String[] args) {
        Console console = new Console();
        CommandManager commandManager = new CommandManager(console);
        CollectionManager collectionManager = new CollectionManager();
        FileManager fileManager = new FileManager("data.xml", console, collectionManager);
        IdManager.setCollectionManager(collectionManager);

        // set all my commands
        commandManager.addCommand("help", new HelpCommand(console, commandManager));
        commandManager.addCommand("info", new InfoCommand(console, collectionManager));
        commandManager.addCommand("show", new ShowCommand(console, collectionManager));
        commandManager.addCommand("add", new AddCommand(console, collectionManager));
        commandManager.addCommand("update", new UpdateCommand(console, collectionManager));
        commandManager.addCommand("remove_by_id", new RemoveByIdCommand(console, collectionManager));
        commandManager.addCommand("clear", new ClearCommand(console, collectionManager));
        commandManager.addCommand("save", new SaveCommand(console, fileManager));
//        commandManager.addCommand("execute_script", new ExecuteScriptCommand(console, commandManager));
        commandManager.addCommand("exit", new ExitCommand(console));
        commandManager.addCommand("add_if_min", new AddIfMinCommand(console, collectionManager));
        commandManager.addCommand("remove_greater", new RemoveGreaterCommand(console, collectionManager));
        commandManager.addCommand("remove_lower", new RemoveLowerCommand(console, collectionManager));
        commandManager.addCommand("min_by_full_name", new MinByFullNameCommand(console, collectionManager));
        commandManager.addCommand("filter_contains_name", new FilterContainsNameCommand(console, collectionManager));
        commandManager.addCommand("filter_less_than_postal_address", new FilterLessThanPostalAddressCommand(console, collectionManager));
        // interactive mode
        new RuntimeManager(console, fileManager, commandManager).interactiveMode();
    }
}