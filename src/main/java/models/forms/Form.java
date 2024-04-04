package models.forms;

import manager.Console;
import models.OrganizationType;

import java.util.Enumeration;
import java.util.Scanner;
import java.util.function.Predicate;

public abstract class Form<T> {
    private final Console console;
    private final Scanner scanner = new Scanner(System.in);

    public Form(Console console) {
        this.console = console;
    }

    public abstract T build();

    public String askString(String fieldName, String restrictions, Predicate<String> validator) {
        while (true) {
            console.println("Введите " + fieldName + restrictions + ": ");
            String input = scanner.nextLine().trim();
            if (validator.test(input)) {
                return input;
            } else {
                console.printError("Неверный формат ввода((");
            }
        }
    }

    public Enum askEnum(String fieldName, Enum[] excteptedValues, Predicate<String> validator) {
        while (true) {
            console.println("Доступные значения '" + fieldName + "': ");
            for (Enum value : excteptedValues) {
                console.println(value.toString() + ",");
            }
            console.println("Введите " + fieldName + ": ");
            String input = scanner.nextLine().trim();
            if (validator.test(input)) {
                for (Enum value : excteptedValues) {
                    if (value.toString().equals(input.toUpperCase())) {
                        return value;
                    }
                }
                console.printError("Неверный формат ввода((");
            } else {
                console.printError("Неверный формат ввода((");
            }
        }
    }

    public Integer askInteger(String fieldName, String restrictions, Predicate<Integer> validator) {
        while (true) {
            console.println("Введите " + fieldName + restrictions + ": ");
            String input = scanner.nextLine().trim();
            try {
                Integer number = Integer.parseInt(input);
                if (validator.test(number)) {
                    return number;
                } else {
                    console.printError("Ошибка валидации((");
                }
            } catch (NumberFormatException e) {
                console.printError("Неверный формат ввода((");
            }
        }
    }

    public Long askLong(String fieldName, String restrictions, Predicate<Long> validator) {
        while (true) {
            console.println("Введите " + fieldName + restrictions + ": ");
            String input = scanner.nextLine().trim();
            try {
                Long number = Long.parseLong(input);
                if (validator.test(number)) {
                    return number;
                } else {
                    console.printError("Ошибка валидации((");
                }
            } catch (NumberFormatException e) {
                console.printError("Неверный формат ввода((");
            }
        }
    }

    public Double askDouble(String fieldName, String restrictions, Predicate<Double> validator) {
        while (true) {
            console.println("Введите " + fieldName + restrictions + ": ");
            String input = scanner.nextLine().trim();
            try {
                Double number = Double.parseDouble(input);
                if (validator.test(number)) {
                    return number;
                } else {
                    console.printError("Ошибка валидации((");
                }
            } catch (NumberFormatException e) {
                console.printError("Неверный формат ввода((");
            }
        }
    }

    public Float askFloat(String fieldName, String restrictions, Predicate<Float> validator) {
        while (true) {
            console.println("Введите " + fieldName + restrictions + ": ");
            String input = scanner.nextLine().trim();
            try {
                Float number = Float.parseFloat(input);
                if (validator.test(number)) {
                    return number;
                } else {
                    console.printError("Ошибка валидации((");
                }
            } catch (NumberFormatException e) {
                console.printError("Неверный формат ввода((");
            }
        }
    }


}
