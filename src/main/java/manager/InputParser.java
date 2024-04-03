package manager;

import java.util.Scanner;

public class InputParser {
    public void parseOrganizationInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название организации:");
        String name = scanner.nextLine();
        System.out.println("Введите координату x:");
        String x = scanner.nextLine();
        System.out.println("Введите координату y:");
        String y = scanner.nextLine();
        System.out.println("Введите годовой оборот организации:");
        String annualTurnover = scanner.nextLine();
        System.out.println("Введите тип организации:");
        String type = scanner.nextLine();
        System.out.println("Введите полное название организации:");
        String fullName = scanner.nextLine();
        System.out.println("Введите количество сотрудников организации:");
        String employeesCount = scanner.nextLine();
        System.out.println("Введите адрес организации:");
        String postalAddress = scanner.nextLine();

    }
}
