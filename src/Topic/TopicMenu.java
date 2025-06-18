package Topic;

import Course.CRUDCourse;
import Course.CoursesStorage;

import static ProgramSystem.Utils.readIntInput;

public class TopicMenu {
    public static void topicMenu() {
        while (true) {
            showTopicsMenu();

            int choice = readIntInput();

            switch (choice) {
                case 1: {
                    CRUDTopic.createTopic();
                    break;
                }
                case 2: {
                    CRUDTopic.retrieveTopic();
                    break;
                }
                case 3: {
                    CRUDTopic.updateTopic();
                    break;
                }
                case 4: {
                    CRUDTopic.deleteTopic();
                    break;
                }
                case 5: {
                    TopicsStorage.writeAllTopics();
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

    public static void showTopicsMenu() {
        System.out.println("\n===Управление темами===");
        System.out.println("1. Создать тему");
        System.out.println("2. Достать тему");
        System.out.println("3. Обновить тему");
        System.out.println("4. Удалить тему");
        System.out.println("5. Вывод всех тем");
        System.out.println("0. Выход");
        System.out.print("Выберите опцию: ");
    }
}
