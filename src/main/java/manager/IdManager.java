package manager;

import lombok.Getter;
import lombok.Setter;


public class IdManager {
    private static long id = 1;
    private static CollectionManager collectionManager;

    public static void setCollectionManager(CollectionManager collectionManager) {
        IdManager.collectionManager = collectionManager;
    }

    private IdManager() {
    }

    // Генерация уникального id
    public static long generateId() {
        if (collectionManager == null) {
            throw new NullPointerException("CollectionManager не инициализирован");
        }
        while (collectionManager.getById(id) != null) {
            id++;
        }

        return id;
    }
}
