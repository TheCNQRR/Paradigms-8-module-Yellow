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

        System.out.println("Установите видимость темы:");
        System.out.println("1. Видна");
        System.out.println("2. Скрыта");
        System.out.print("Выберите опцию: ");

        int choiceVisibility = readIntInput();
        boolean isSetVisibility = false;

        while (!isSetVisibility) {
            if (choiceVisibility != 1 && choiceVisibility != 2) {
                System.out.print("Ошибка, вы ввели неверное число! Повторите попытку: ");
                choiceVisibility = readIntInput();
            }
            else {
                isSetVisibility = true;
            }
        }

        switch (choiceVisibility) {
            case 1: {
                course.setTopicVisibility(topicName, true);
                break;
            }
            case 2: {
                course.setTopicVisibility(topicName, false);
                break;
            }
            default: {
                System.out.println("Ошибка, неверная команда!");
            }
        }

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
        System.out.println("Тема создана!");
    }
}
