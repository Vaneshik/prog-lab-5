import commandManagement.commands.*;
import manager.*;
import models.*;

import javax.xml.bind.JAXBException;

public class Main {
    public static void main(String[] args) throws JAXBException {
        Console console = new Console();
        CommandManager commandManager = new CommandManager(console);
        CollectionManager collectionManager = new CollectionManager();
        FileManager fileManager = new FileManager("input.xml", console, collectionManager);

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

//
//        // test
//        commandManager.executeCommand("help", new String[]{});
//
//        collectionManager.add(new Organization("meow", new Coordinates(1d, 1f), 1d, "Freak Freak", 125, OrganizationType.COMMERCIAL, new Address("street1", new Location(1L, 1d, "town1"))));
//        collectionManager.add(new Organization("meow1", new Coordinates(1d, 1f), 1d, "Not a Freak Freak", 125, OrganizationType.COMMERCIAL, new Address("street1", new Location(1L, 1d, "town1"))));
//        collectionManager.add(new Organization("meow2", new Coordinates(1d, 1f), 1d, "Totally Freak Freak", 125, OrganizationType.COMMERCIAL, new Address("street1", new Location(1L, 1d, "town1"))));
//        collectionManager.add(new Organization("meow3", new Coordinates(1d, 1f), 1d, "A Totally Freak Freak", 125, OrganizationType.COMMERCIAL, new Address("street1", new Location(1L, 1d, "town1"))));
//
//        commandManager.executeCommand("show", new String[]{});
//        commandManager.executeCommand("min_by_full_name", new String[]{});
//
//        commandManager.executeCommand("remove_by_id", new String[]{"1"});
//        commandManager.executeCommand("show", new String[]{});
//
//        commandManager.executeCommand("clear", new String[]{});
//        collectionManager.add(new Organization("meow3", new Coordinates(1d, 1f), 1d, "A Totally Freak Freak", 125, OrganizationT`ype.COMMERCIAL, new Address("street1", new Location(1L, 1d, "town1"))));
//
//        commandManager.executeCommand("show", new String[]{});
//
//        collectionManager.add(new Organization("meow4", new Coordinates(1d, 1f), 1d, "A Totally Freak Freak", 125, OrganizationType.COMMERCIAL, new Address("1234", new Location(1L, 1d, "town1"))));
//        collectionManager.update(5, new Organization("meow3 but freak", new Coordinates(1d, 1f), 1d, "A Totally Freak Freak", 125, OrganizationType.COMMERCIAL, new Address("9843483", new Location(1L, 1d, "town1"))));
//
//        commandManager.executeCommand("show", new String[]{});
//        commandManager.executeCommand("info", new String[]{});
//
//        commandManager.executeCommand("filter_contains_name", new String[]{"fr"});
//
//        collectionManager.filterLessThanPostalAddress(new Address("9999999", new Location(1L, 1d, "town1")));
//
//        commandManager.executeCommand("exit", new String[]{});
    }
}