package Course;

import java.util.Scanner;

import static ProgramSystem.Utils.readIntInput;

public class CRUDCourse {
    public static void createCourse() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название класса: ");
        String name = scanner.nextLine();

        Course course = new Course(name);

        CoursesStorage.addCourse(course);

        System.out.println("Создать тему внутри класса?");
        System.out.println("1. Да");
        System.out.println("2. Нет");
        System.out.print("Выберите опцию: ");

        int choiceForTopic = readIntInput();

        switch (choiceForTopic) {
            case 1: {
                break;
            }
            case 2: {

            }
            default: {
                System.out.println("Ошибка, неверная команда!");
            }
        }
        System.out.println("Класс добавлен!");
    }
}
