package Topic;

import Course.Course;
import CourseModule.CRUDModule;

import java.util.Scanner;

import static ProgramSystem.Utils.readIntInput;

public class CRUDTopic {
    public static void createTopic(Course course) {
        Scanner scanner = new Scanner(System.in);
        String topicName;

        System.out.print("Введите название темы: ");
        topicName = scanner.nextLine();
        course.addTopicName(topicName);

        System.out.println("Добавление модуля/секции в тему");
        System.out.println("1. Создать модуль");
        System.out.println("2. Создать секцию");
        System.out.print("Выберите опцию: ");

        int choice = readIntInput();
        boolean isSet = false;

        while (!isSet) {
            if (choice != 1 && choice != 2) {
                System.out.print("Ошибка, вы ввели неверное число! Повторите попытку: ");
                choice = readIntInput();
            }
            else {
                isSet = true;
            }
        }

        switch (choice) {
            case 1: {
                CRUDModule.createModuleInCourse(topicName, course);
                break;
            }
            case 2: {

                break;
            }
            default: {
                System.out.println("Ошибка, неверная команда!");
            }
        }
        //TODO добавление задания в тему (опционально)
        System.out.println("Тема создана!");
    }
}
