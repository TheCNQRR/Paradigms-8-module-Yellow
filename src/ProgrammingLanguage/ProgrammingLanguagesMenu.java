package ProgrammingLanguage;

import static ProgramSystem.Utils.readIntInput;

public class ProgrammingLanguagesMenu {
    public static void programmingLanguagesMenu() {
        while (true) {
            showProgrammingLanguagesMenu();

            int choice = readIntInput();

            switch (choice) {
                case 1: {
                    CreateProgrammingLanguage.createProgrammingLanguage();
                    break;
                }
                case 2: {
                    RetrieveProgrammingLanguage.retrieveProgrammingLanguage();
                    break;
                }
                case 3: {
                    UpdateProgrammingLanguage.updateProgrammingLanguage();
                    break;
                }
                case 4: {
                    DeleteProgrammingLanguage.deleteProgrammingLanguage();
                    break;
                }
                case 5: {
                    ProgrammingLanguage.writeAllLanguages();
                    break;
                }
                case 0: {
                    return;
                }
                default: {
                    System.out.println("Ошибка, неверная команда!");
                }
            }
        }
    }

    public static void showProgrammingLanguagesMenu() {
        System.out.println("\n===Управление языками программирования===");
        System.out.println("1. Создать ЯП");
        System.out.println("2. Достать ЯП");
        System.out.println("3. Обновить ЯП");
        System.out.println("4. Удалить ЯП");
        System.out.println("5. Вывод всех ЯП");
        System.out.println("0. Выход");
        System.out.print("Выберите опцию: ");
    }
}
