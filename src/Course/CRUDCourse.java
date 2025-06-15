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

    public static void updateCourse() {
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

    public static void updateTopics(Course course) {
        Scanner scanner = new Scanner(System.in);

        if (course.getTopics().isEmpty()) {
            CRUDTopic.createTopic(course);
        } else {
            course.writeTopics();
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

        if (course.getTopics().isEmpty()) {
            CRUDTopic.createTopic(course);
        } else {
            course.writeModules(course);
            System.out.println("Редактирование модулей");
            System.out.println("1. Добавить новый модуль");
            System.out.println("2. Удалить модуль");
            System.out.println("3. Редактировать модуль");
            System.out.print("Выберите опцию: ");

            int choiceForModule = readIntInput();

            switch (choiceForModule) {
                case 1: {
                    if (course.getTopics().isEmpty()) {
                        System.out.println("Список тем пуст, сперва создайте тему!");
                        return;
                    }
                    else {
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
                    }
                    break;
                }
                case 2: {
                    course.writeTopics();
                    System.out.print("Введите номер темы, внутри которой будет удалён модуль: ");
                    int topicNumber = readIntInput();
                    if (topicNumber < 1 || topicNumber > course.getTopics().size()) {
                        System.out.println("Ошибка, вы ввели неверный номер!");
                        return;
                    }
                    else {
                        course.writeModules(course);
                        System.out.print("Введите номер модуля, который хотите удалить: ");
                        int deletingModule = readIntInput();

                        if (deletingModule < 1 || deletingModule > course.getModules().size()) {
                            System.out.println("Ошибка, вы ввели неверный номер!");
                        }
                        else {
                            course.removeModuleAtIndex(deletingModule - 1);
                            System.out.println("Модуль удалён!");
                        }
                        break;
                    }

                }
                case 3: {
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
}
