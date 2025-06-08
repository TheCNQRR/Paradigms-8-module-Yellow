package ProgrammingLanguage;

import java.util.Scanner;

import static ProgramSystem.Utils.readIntInput;

public class UpdateProgrammingLanguage {
    public static void updateProgrammingLanguage() {
        if (ProgrammingLanguage.getLanguages().isEmpty()) {
            System.out.println("Список языков пуст!");
            return;
        }

        ProgrammingLanguage.writeAllLanguages();

        System.out.print("Введите номер языка, который хотите обновить: ");
        int choice = readIntInput();

        if (choice > ProgrammingLanguage.getLanguages().size() || choice < 1) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        ProgrammingLanguage.writeLanguage(ProgrammingLanguage.getLanguages().get(choice - 1));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите новое название для языка: ");
        String newName = scanner.nextLine();

        ProgrammingLanguage newLanguage = new ProgrammingLanguage(newName);

        System.out.println("Язык \"" + ProgrammingLanguage.getLanguages().get(choice - 1).getName() + "\" заменён!");
        ProgrammingLanguage.replaceLanguage(choice - 1, newLanguage);
        System.out.println("Новое название: " + ProgrammingLanguage.getLanguages().get(choice - 1).getName());
    }
}
