package ProgrammingLanguage;

import java.util.Scanner;

import static ProgramSystem.Utils.readIntInput;

public class CRUDProgrammingLanguage {
    public static void createProgrammingLanguage() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название языка программирования: ");
        String name = scanner.nextLine();

        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage(name);

        ProgrammingLanguage.addLanguage(programmingLanguage);
        System.out.println("Язык добавлен!");
    }

    public static void retrieveProgrammingLanguage() {
        ProgrammingLanguage.writeAllLanguages();

        System.out.print("Введите номер языка, который хотите достать: ");
        int choice = readIntInput();

        if (choice > ProgrammingLanguage.getLanguages().size() || choice < 1) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        ProgrammingLanguage.writeLanguage(ProgrammingLanguage.getLanguages().get(choice - 1));
    }

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

    public static void deleteProgrammingLanguage() {
        if (ProgrammingLanguage.getLanguages().isEmpty()) {
            System.out.println("Список языков пуст!");
            return;
        }

        ProgrammingLanguage.writeAllLanguages();

        System.out.print("Введите номер языка, который хотите удалить: ");
        int choice = readIntInput();

        if (choice > ProgrammingLanguage.getLanguages().size() || choice < 1) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        System.out.println("Язык \"" + ProgrammingLanguage.getLanguages().get(choice - 1).getName() + "\" удалён!");
        ProgrammingLanguage.removeLanguageAtIndex(choice - 1);
    }
}
