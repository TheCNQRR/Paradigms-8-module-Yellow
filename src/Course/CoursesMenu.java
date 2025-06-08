package Course;

import static ProgramSystem.Utils.readIntInput;

public class CoursesMenu {
    public static void coursesMenu() {
        while (true) {
            showCoursesMenu();

            int choice = readIntInput();

            switch (choice) {
                case 1: {
                    CreateCourse.createCourse();
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

    public static void showCoursesMenu() {
        System.out.println("\n===Управление классами===");
        System.out.println("1. Создать класс");
        System.out.println("2. Достать класс");
        System.out.println("3. Обновить класс");
        System.out.println("4. Удалить класс");
        System.out.println("0. Выход");
        System.out.print("Выберите опцию: ");
    }
}
