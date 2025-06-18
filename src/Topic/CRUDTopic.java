package Topic;

import Course.Course;
import Course.CoursesStorage;
import CourseModule.CRUDModule;
import CourseModule.CourseModule;
import Section.CRUDSection;
import Section.Section;

import java.util.Scanner;

import static ProgramSystem.Utils.readIntInput;

public class CRUDTopic {
    public static void createTopic() {
        if (CoursesStorage.getCourses().isEmpty()) {
            System.out.println("Список классов пуст, сперва создайте класс!");
            return;
        }

        for (int i = 0; i < CoursesStorage.getCourses().size(); ++i) {
            System.out.println("Класс " + (i + 1) + ": " + CoursesStorage.getCourses().get(i).getName());
        }

        System.out.print("Введите номер класса, внутри которого будет создана тема: ");
        int choice = readIntInput();

        if (choice < 1 || choice > CoursesStorage.getCourses().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }
        else {
            Course course = CoursesStorage.getCourses().get(choice - 1);
            createTopicInCourse(course);
        }
    }

    public static void retrieveTopic() {
        if (CoursesStorage.getCourses().isEmpty()) {
            System.out.println("Список классов пуст, сперва создайте класс!");
            return;
        }

        for (int i = 0; i < CoursesStorage.getCourses().size(); ++i) {
            System.out.println("Класс " + (i + 1) + ": " + CoursesStorage.getCourses().get(i).getName());
        }

        System.out.print("Введите номер класса, внутри которого будет выведена тема: ");
        int choice = readIntInput();

        if (choice < 1 || choice > CoursesStorage.getCourses().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }
        else {
            Course course = CoursesStorage.getCourses().get(choice - 1);
            if (course.getTopics().isEmpty()) {
                System.out.println("Список тем пуст!");
                return;
            }

            course.writeTopics();

            System.out.print("Введите номер темы, которую хотите достать: ");
            int topicNumber = readIntInput();

            if (topicNumber < 1 || topicNumber > course.getTopicsNames().size()) {
                System.out.println("Ошибка, вы ввели неверный номер!");
                return;
            }

                String topicName = course.getTopicsNames().get(topicNumber - 1);
                boolean isTopicVisible = course.isTopicVisible(topicName);
                String topicStatus = isTopicVisible ? "" : " [Скрыта]";

                System.out.println("Тема " + topicName + topicStatus);

                int moduleCounter = 1;
                for (Topic topic : course.getTopics()) {
                    if (topic instanceof CourseModule) {
                        CourseModule module = (CourseModule) topic;
                        if (module.getName().equals(topicName)) {
                            String moduleStatus = isTopicVisible ? "" : " [Скрыт]";
                            System.out.println("|--Модуль " + moduleCounter + ": " +
                                    module.getModuleName() + moduleStatus);
                            moduleCounter++;

                            if (!module.getChildren().isEmpty()) {
                                course.printNestedModules(module, 3, isTopicVisible);
                            }
                        }
                    }
                }

                int sectionCounter = 1;
                for (Topic topic : course.getTopics()) {
                    if (topic instanceof Section) {
                        Section section = (Section) topic;
                        if (section.getName().equals(topicName)) {
                            String sectionStatus = isTopicVisible ? "" : " [Скрыта]";
                            System.out.println("|--Секция " + sectionCounter + ": " +
                                    section.getSectionName() + sectionStatus);
                            sectionCounter++;
                        }
                    }
                }

        }
    }

    public static void updateTopic() {
        if (CoursesStorage.getCourses().isEmpty()) {
            System.out.println("Список классов пуст, сперва создайте класс!");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < CoursesStorage.getCourses().size(); ++i) {
            System.out.println("Класс " + (i + 1) + ": " + CoursesStorage.getCourses().get(i).getName());
        }

        System.out.print("Введите номер класса, внутри которого будет обновлена тема: ");
        int choice = readIntInput();

        if (choice < 1 || choice > CoursesStorage.getCourses().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }
        else {
            Course course = CoursesStorage.getCourses().get(choice - 1);
            if (course.getTopicsNames().isEmpty()) {
                System.out.println("Список тем пуст!");
                return;
            }

            course.writeTopics();
            System.out.print("Введите номер темы, которую хотите редактировать: ");
            int updatingTopic = readIntInput();
            if (updatingTopic < 1 || updatingTopic > course.getTopics().size()) {
                System.out.println("Ошибка, вы ввели неверный номер!");
            }
            else {
                course.writeTopicAtIndex(updatingTopic - 1);
                System.out.println("Что вы хотите изменить?");
                System.out.println("1. Название");
                System.out.println("2. Видимость");
                System.out.print("Выберите опцию: ");
                int choiceForChange = readIntInput();

                switch (choiceForChange) {
                    case 1: {
                        System.out.print("Введите новое название темы: ");
                        String newName = scanner.nextLine();
                        Topic topic = course.getTopics().get(updatingTopic - 1);
                        topic.setName(newName);
                        course.replaceTopic(updatingTopic - 1, topic);
                        course.replaceTopicName(updatingTopic - 1, newName);
                        System.out.println("Название темы изменено!");
                        break;
                    }
                    case 2: {
                        course.setTopicVisibility(course.getTopics().get(updatingTopic - 1).getName(), !course.isTopicVisible(course.getTopics().get(updatingTopic - 1).getName()));
                        System.out.println("Видимость изменена!");
                        break;
                    }
                }
            }
        }
    }

    public static void deleteTopic() {
        if (CoursesStorage.getCourses().isEmpty()) {
            System.out.println("Список классов пуст, сперва создайте класс!");
            return;
        }

        for (int i = 0; i < CoursesStorage.getCourses().size(); ++i) {
            System.out.println("Класс " + (i + 1) + ": " + CoursesStorage.getCourses().get(i).getName());
        }

        System.out.print("Введите номер класса, внутри которого будет удалена тема: ");
        int choice = readIntInput();

        if (choice < 1 || choice > CoursesStorage.getCourses().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }
        else {
            Course course = CoursesStorage.getCourses().get(choice - 1);
            if (course.getTopicsNames().isEmpty()) {
                System.out.println("Список тем пуст!");
                return;
            }

            course.writeTopics();
            System.out.print("Введите номер темы, которую хотите удалить: ");
            int deletingTopic = readIntInput();

            if (deletingTopic < 1 || deletingTopic > course.getTopics().size()) {
                System.out.println("Ошибка, вы ввели неверный номер!");
            }
            else {
                course.removeTopicAtIndex(deletingTopic - 1);
                course.removeTopicNameAtIndex(deletingTopic - 1);
                System.out.println("Тема удалена!");
            }
        }
    }

    public static void createTopicInCourse(Course course) {
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
                CRUDSection.createSectionInCourse(topicName, course);
                break;
            }
            default: {
                System.out.println("Ошибка, неверная команда!");
            }
        }
        System.out.println("Тема создана!");
    }
}
