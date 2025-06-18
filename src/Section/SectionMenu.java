package Section;

import Section.SectionsStorage;

import static ProgramSystem.Utils.readIntInput;

public class SectionMenu {
    public static void sectionsMenu() {
        while (true) {
            showSectionsMenu();

            int choice = readIntInput();

            switch (choice) {
                case 1: {
                    CRUDSection.createSection();
                    break;
                }
                case 2: {
                    CRUDSection.retrieveSection();
                    break;
                }
                case 3: {
                    CRUDSection.updateSection();
                    break;
                }
                case 4: {
                    CRUDSection.deleteSection();
                    break;
                }
                case 5: {
                    SectionsStorage.writeAllSections();
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

    public static void showSectionsMenu() {
        System.out.println("\n===Управление секциями===");
        System.out.println("1. Создать секцию");
        System.out.println("2. Достать секцию");
        System.out.println("3. Обновить секцию");
        System.out.println("4. Удалить секцию");
        System.out.println("5. Вывод всех секций");
        System.out.println("0. Выход");
        System.out.print("Выберите опцию: ");
    }
}
