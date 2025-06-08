package ProgrammingLanguage;

import static ProgramSystem.Utils.readIntInput;

public class RetrieveProgrammingLanguage {
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
}
