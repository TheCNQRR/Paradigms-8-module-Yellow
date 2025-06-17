package CourseModule;

import Course.Course;
import Course.CoursesStorage;
import Course.CRUDCourse;
import Topic.Topic;

import java.util.Scanner;

import static ProgramSystem.Utils.readIntInput;

public class CRUDModule {
    public static void createModule() {
        if (CoursesStorage.getCourses().isEmpty()) {
            System.out.println("Список классов пуст, сперва создайте класс!");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Создание модуля");
        CoursesStorage.writeAllCourses();
        System.out.print("Введите номер класса внутри которого будет создан модуль: ");
        int courseNumber = readIntInput();

        if (courseNumber < 1 || courseNumber > CoursesStorage.getCourses().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }
        else {
            Course course = CoursesStorage.getCourses().get(courseNumber - 1);
            System.out.println("Где вы хотите создать новый модуль?");
            System.out.println("1. Внутри темы");
            System.out.println("2. Внутри модуля");
            System.out.print("Выберите опцию: ");
            int choice = readIntInput();

            switch (choice) {
                case 1: {
                    course.writeTopics();
                    System.out.print("Введите номер темы, внутри которой будет создан модуль: ");
                    int topicNumber = readIntInput();
                    if (topicNumber < 1 || topicNumber > course.getTopics().size()) {
                        System.out.println("Ошибка, вы ввели неверный номер!");
                        return;
                    }
                    else {
                        CRUDModule.createModuleInCourse(course.getTopics().get(topicNumber - 1).getName(), course);
                    }
                    break;
                }
                case 2: {
                    course.writeModules(course);
                    System.out.print("Введите номер модуля, внутри которого будет создан модуль: ");
                    int choiceForCreateModule = readIntInput();

                    if (choiceForCreateModule < 1 || choiceForCreateModule > course.getModules().size()) {
                        System.out.println("Ошибка, вы ввели неверный номер!");
                        return;
                    }
                    else {
                        CourseModule module = course.getModules().get(choiceForCreateModule - 1);

                        System.out.print("Введите название нового модуля: ");
                        String name = scanner.nextLine();
                        CourseModule newModule = new CourseModule(module.getName(), name, course);
                        newModule.setParent(module);
                        CourseModule originalModule = module;
                        module.addChildren(newModule);
                        for (int i = 0; i < course.getTopics().size(); ++i) {
                            Topic topic = course.getTopics().get(i);
                            if (topic instanceof CourseModule) {
                                CourseModule tempModule = (CourseModule) topic;
                                if (tempModule == originalModule) {
                                    course.replaceTopic(i, module);
                                    break;
                                }
                            }
                        }
                        course.addModule(newModule);
                        System.out.println("Модуль добавлен!");
                    }
                    break;
                }
                default: {
                    System.out.println("Ошибка, неверная команда!");
                }
            }
        }
    }

    public static void retrieveModule() {
        if (CoursesStorage.getCourses().isEmpty()) {
            System.out.println("Список классов пуст, сперва создайте класс!");
            return;
        }

        int modulesNumber = 0;
        for (int i = 0; i < CoursesStorage.getCourses().size(); ++i) {
            for (int j = 0; j < CoursesStorage.getCourses().get(i).getModules().size(); ++j) {
                System.out.println("Модуль " + (modulesNumber + 1) + ": " + CoursesStorage.getCourses().get(i).getModules().get(j).getModuleName());
                modulesNumber++;
            }
        }

        if (modulesNumber == 0) {
            System.out.println("Список модулей пуст!");
            return;
        }

        System.out.print("Введите номер модуля, который хотите достать: ");
        int retrieveModule = readIntInput();

        if (retrieveModule < 1 || retrieveModule > modulesNumber) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }
        else {
            int temp = 0;
            for (int i = 0; i < CoursesStorage.getCourses().size(); ++i) {
                for (int j = 0; j < CoursesStorage.getCourses().get(i).getModules().size(); ++j) {
                    temp++;
                    if (retrieveModule == temp) {
                        System.out.println("Информация о модуле: ");
                        System.out.println("Родительская тема: " + CoursesStorage.getCourses().get(i).getModules().get(j).getName());
                        System.out.println("Название модуля: " + CoursesStorage.getCourses().get(i).getModules().get(j).getModuleName());
                        System.out.println("Родитель: " + CoursesStorage.getCourses().get(i).getModules().get(j).getParent().getModuleName());
                        if (!CoursesStorage.getCourses().get(i).getModules().get(j).getChildren().isEmpty()) {
                            for (int k = 0; k < CoursesStorage.getCourses().get(i).getModules().get(j).getChildren().size(); ++k) {
                                System.out.println("Потомок " + (k + 1) + ": " + CoursesStorage.getCourses().get(i).getModules().get(j).getChildren().get(k).getModuleName());
                            }
                        }
                        else {
                            System.out.println("Список потомков пуст!");
                        }
                        break;
                    }
                }
            }
        }
    }

    public static void updateModule() {
        Scanner scanner = new Scanner(System.in);
        CoursesStorage.writeAllCourses();
        System.out.print("Введите номер класса, в котором вы хотите изменить модуль: ");
        int updatingCourse = readIntInput();

        if (updatingCourse < 1 || updatingCourse > CoursesStorage.getCourses().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }
        else {
            Course course = CoursesStorage.getCourses().get(updatingCourse - 1);
            course.writeModules(course);
            System.out.print("Введите номер модуля, который хотите редактировать: ");
            int updatingModule = readIntInput();
            if (updatingModule < 1 || updatingModule > course.getModules().size()) {
                System.out.println("Ошибка, вы ввели неверный номер!");
            }
            else {
                System.out.print("Введите новое название модуля: ");
                String newName = scanner.nextLine();
                CourseModule module = course.getModules().get(updatingModule - 1);

                CourseModule originalModule = module;
                originalModule.setModuleName(newName);
                course.replaceModule(updatingModule - 1, originalModule);

                for (int i = 0; i < course.getTopics().size(); ++i) {
                    Topic topic = course.getTopics().get(i);
                    if (topic instanceof CourseModule) {
                        CourseModule temp = (CourseModule) topic;
                        if (temp == originalModule) {
                            temp.setModuleName(newName);
                            course.replaceTopic(i, temp);
                        }
                    }
                }
                System.out.println("Название модуля изменено!");
            }
        }
    }

    public static void deleteModule() {
        Scanner scanner = new Scanner(System.in);
        CoursesStorage.writeAllCourses();
        System.out.print("Введите номер класса, в котором вы хотите удалить модуль: ");
        int updatingCourse = readIntInput();

        if (updatingCourse < 1 || updatingCourse > CoursesStorage.getCourses().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }
        else {
            Course course = CoursesStorage.getCourses().get(updatingCourse - 1);
            course.writeModules(course);
            System.out.print("Введите номер модуля, который хотите удалить: ");
            int deletingModule = readIntInput();
            if (deletingModule < 1 || deletingModule > course.getModules().size()) {
                System.out.println("Ошибка, вы ввели неверный номер!");
            }
            else {
                CourseModule module = course.getModules().get(deletingModule - 1);
                for (int i = 0; i < course.getTopics().size(); ++i) {
                    Topic topic = course.getTopics().get(i);
                    if (topic instanceof CourseModule) {
                        CourseModule tempModule = (CourseModule) topic;
                        if (tempModule == module) {
                            course.removeTopicAtIndex(i);
                            break;
                        }
                    }
                }
                course.removeModuleAtIndex(deletingModule - 1);
                System.out.println("Модуль удалён!");
            }
        }
    }

    public static void createModuleInCourse(String topicName, Course course) {
        Scanner scanner = new Scanner(System.in);

        String moduleName;
        System.out.print("Введите название модуля: ");
        moduleName = scanner.nextLine();
        CourseModule module = new CourseModule(topicName, moduleName, course);
        module.setParent(module);
        course.addTopic(module);
        course.addModule(module);

        ModulesStorage.addModule(module);
        System.out.println("Модуль добавлен!");
    }
}
