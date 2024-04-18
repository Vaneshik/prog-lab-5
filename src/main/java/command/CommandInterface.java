package command;

/**
 * Интерфейс команд.
 */
public interface CommandInterface {
    /**
     * Выполняет команду
     *
     * @param args аргументы
     */
    void execute(String[] args);
}
