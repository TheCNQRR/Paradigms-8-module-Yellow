package ProgramSystem;

import static ProgramSystem.Console.scanner;

public class Utils {
    public static int readIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Ошибка! Введите число: ");
            }
        }
    }
}
