package CourseModule;

import Course.CRUDCourse;
import Course.CoursesStorage;

import static ProgramSystem.Utils.readIntInput;

public class ModulesMenu {
    public static void modulesMenu() {
        while (true) {
            showModulesMenu();

            int choice = readIntInput();

            switch (choice) {
                case 1: {
                    CRUDModule.createModule();
                    break;
                }
                case 2: {
                    CRUDModule.retrieveModule();
                    break;
                }
                case 3: {
                    CRUDModule.updateModule();
                    break;
                }
                case 4: {
                    CRUDModule.deleteModule();
                    break;
                }
                case 5: {
                    ModulesStorage.writeAllModules();
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

    public static void showModulesMenu() {
        System.out.println("\n===Управление модулями===");
        System.out.println("1. Создать модуль");
        System.out.println("2. Достать модуль");
        System.out.println("3. Обновить модуль");
        System.out.println("4. Удалить модуль");
        System.out.println("5. Вывод всех модулей");
        System.out.println("0. Выход");
        System.out.print("Выберите опцию: ");
    }
}
