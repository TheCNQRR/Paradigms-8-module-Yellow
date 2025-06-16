package Course;

import java.util.Scanner;

import CourseModule.CRUDModule;
import CourseModule.CourseModule;
import Topic.CRUDTopic;
import Topic.Topic;

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
                CRUDTopic.createTopic(course);
                break;
            }
            case 2: {
                System.out.println("Добавление темы пропущено. Вы можете добавить тему позднее!");
                break;
            }
            default: {
                System.out.println("Ошибка, неверная команда!");
            }
        }
        System.out.println("Класс добавлен!");
    }

    public static void retrieveCourse() {
        if (CoursesStorage.getCourses().isEmpty()) {
            System.out.println("Список классов пуст!");
            return;
        }

        for (int i = 0; i < CoursesStorage.getCourses().size(); ++i) {
            System.out.println("{");
            System.out.println("Название класса " + (i + 1) + ": " + CoursesStorage.getCourses().get(i).getName());
            System.out.println("}");
        }

        System.out.print("Введите номер класса, который хотите достать: ");
        int retrieveCourse = readIntInput();

        if (retrieveCourse < 1 || retrieveCourse > CoursesStorage.getCourses().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
        }
        else {
            System.out.println("|Класс :" + CoursesStorage.getCourses().get(retrieveCourse - 1).getName());
            CoursesStorage.getCourses().get(retrieveCourse - 1).writeModulesInCourse(CoursesStorage.getCourses().get(retrieveCourse - 1));
        }
    }

    public static void updateCourse() {
        if (CoursesStorage.getCourses().isEmpty()) {
            System.out.println("Список классов пуст!");
            return;
        }
        CoursesStorage.writeAllCourses();
        System.out.print("Введите номер класса, который вы хотите обновить: ");
        int choice = readIntInput();

        if (choice < 1 || choice > CoursesStorage.getCourses().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }
        else {
            Course course = CoursesStorage.getCourses().get(choice - 1);
            System.out.println("Что вы хотите изменить?");
            System.out.println("1. Список тем (добавление/удаление/редактирование темы)");
            System.out.println("2. Список модулей (аналогично темам)");
            System.out.println("3. Список секций (аналогично темам)");
            System.out.print("Выберите опцию: ");
            int choiceForUpdate = readIntInput();

            switch (choiceForUpdate) {
                case 1: {
                    updateTopics(course);
                    break;
                }
                case 2: {
                    updateModules(course);
                    break;
                }
                default: {
                    System.out.println("Ошибка, неверная команда!");
                }
            }
        }
    }

    public static void deleteCourse() {
        if (CoursesStorage.getCourses().isEmpty()) {
            System.out.println("Список классов пуст!");
            return;
        }

        CoursesStorage.writeAllCourses();
        System.out.print("Введите номер класса, который хотите удалить: ");
        int deletingCourse = readIntInput();

        if (deletingCourse < 1 || deletingCourse > CoursesStorage.getCourses().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
        }
        else {
            CoursesStorage.removeCourseAtIndex(deletingCourse - 1);
            System.out.println("Класс удалён!");
        }
    }

    public static void updateTopics(Course course) {
        Scanner scanner = new Scanner(System.in);

        if (course.getTopicsNames().isEmpty()) {
            System.out.println("Список тем пуст!");
            return;
        }
        else {
            System.out.println("Редактирование тем");
            System.out.println("1. Добавить новую тему");
            System.out.println("2. Удалить тему");
            System.out.println("3. Редактировать тему");
            System.out.print("Выберите опцию: ");

            int choiceForTopic = readIntInput();

            switch (choiceForTopic) {
                case 1: {
                    CRUDTopic.createTopic(course);
                    break;
                }
                case 2: {
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
                    break;
                }
                case 3: {
                    course.writeTopics();
                    System.out.print("Введите номер темы, которую хотите редактировать: ");
                    int updatingTopic = readIntInput();
                    if (updatingTopic < 1 || updatingTopic > course.getTopics().size()) {
                        System.out.println("Ошибка, вы ввели неверный номер!");
                    }
                    else {
                        course.writeTopicAtIndex(updatingTopic - 1);
                        System.out.print("Введите новое название темы: ");
                        String newName = scanner.nextLine();
                        Topic topic = course.getTopics().get(updatingTopic - 1);
                        topic.setName(newName);
                        course.replaceTopic(updatingTopic - 1, topic);
                        course.replaceTopicName(updatingTopic - 1, newName);
                        System.out.println("Название темы изменено!");
                    }
                    break;
                }
                default: {
                    System.out.println("Ошибка, неверная команда!");
                }
            }
        }
    }

    public static void updateModules(Course course) {
        Scanner scanner = new Scanner(System.in);

        if (course.getTopicsNames().isEmpty()) {
            System.out.println("Список тем пуст, сперва создайте тему!");
            return;
        }
        else {
            System.out.println("Редактирование модулей");
            System.out.println("1. Добавить новый модуль");
            System.out.println("2. Удалить модуль");
            System.out.println("3. Редактировать модуль");
            System.out.print("Выберите опцию: ");

            int choiceForModule = readIntInput();

            switch (choiceForModule) {
                case 1: {
                    if (course.getTopicsNames().isEmpty()) {
                        System.out.println("Список тем пуст, сперва создайте тему!");
                        return;
                    }
                    else {
                        System.out.println("Где вы хотите создать модуль?");
                        System.out.println("1. Внутри темы");
                        System.out.println("2. Внутри модуля");
                        System.out.print("Выберите опцию: ");
                        int choiceForCreate = readIntInput();
                        switch (choiceForCreate) {
                            case 1: {
                                course.writeTopics();
                                System.out.print("Введите номер темы, внутри которой будет создан модуль: ");
                                int updatingModule = readIntInput();
                                if (updatingModule < 1 || updatingModule > course.getTopics().size()) {
                                    System.out.println("Ошибка, вы ввели неверный номер!");
                                    return;
                                }
                                else {
                                    CRUDModule.createModule(course.getTopics().get(updatingModule - 1).getName(), course);
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
                                    module.addChildren(newModule);
                                    for (int i = 0; i < course.getTopics().size(); ++i) {
                                        Topic topic = course.getTopics().get(i);
                                        if (topic instanceof CourseModule) {
                                            CourseModule tempModule = (CourseModule) topic;
                                            if (tempModule.getModuleName().equals(module.getModuleName())) {
                                                course.replaceTopic(i, tempModule);
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
                    break;
                }
                case 2: {
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
                    break;
                }
                case 3: {
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
                    break;
                }
                default: {
                    System.out.println("Ошибка, неверная команда!");
                }
            }
        }
    }
}
