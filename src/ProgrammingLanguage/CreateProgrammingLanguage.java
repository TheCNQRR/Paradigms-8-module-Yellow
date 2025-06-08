package ProgrammingLanguage;

import java.util.Scanner;

public class CreateProgrammingLanguage {
    public static void createProgrammingLanguage() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название языка программирования: ");
        String name = scanner.nextLine();

        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage(name);

        ProgrammingLanguage.addLanguage(programmingLanguage);
        System.out.println("Язык добавлен!");
    }
}
