package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Менеджер скриптов.
 */
public class ScriptManager {
    private static final Stack<String> pathStack = new Stack<>();
    private static final Stack<Scanner> scanners = new Stack<>();

    /**
     * Добавить файл в стек.
     *
     * @param path путь к файлу
     * @throws FileNotFoundException файл не найден
     */
    public static void addFile(String path) throws FileNotFoundException {
        pathStack.push(new File(path).getAbsolutePath());
        scanners.push(new Scanner(new File(path)));
    }

    /**
     * Проверка на рекурсию.
     *
     * @param path путь к файлу
     * @return true, если файл рекурсивный
     */
    public static boolean isRecursive(String path) {
        return pathStack.contains(new File(path).getAbsolutePath());
    }

    /**
     * Удалить файл из стека.
     */
    public static void removeFile() {
        scanners.pop();
        pathStack.pop();
    }

    /**
     * Считать следующую строку из файла.
     *
     * @return строка
     */
    public static String nextLine() {
        try {
            return scanners.lastElement().nextLine();
        } catch (Exception e) {
            return "";
        }
    }
}
