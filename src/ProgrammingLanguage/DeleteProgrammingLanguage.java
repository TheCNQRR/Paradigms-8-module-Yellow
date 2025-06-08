package ProgrammingLanguage;

import static ProgramSystem.Utils.readIntInput;

public class DeleteProgrammingLanguage {
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
