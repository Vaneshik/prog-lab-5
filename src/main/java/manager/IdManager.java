package manager;

public class IdManager {
    private static long id = 1;

    private IdManager() {
    }

    // Генерация уникального id

    public static long generateId() {
        return id++;
    }
}
