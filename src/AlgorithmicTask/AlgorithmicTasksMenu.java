package AlgorithmicTask;

import static ProgramSystem.Utils.readIntInput;

public class AlgorithmicTasksMenu {
    public static void algorithmicTasksMenu() {
        while (true) {
            showAlgorithmicTasksMenu();

            int choice = readIntInput();

            switch(choice) {
                case 1: {
                    CRUDAlgorithmicTask.createAlgorithmicTask();
                    break;
                }
                case 2: {
                    CRUDAlgorithmicTask.retrieveAlgorithmicTask();
                    break;
                }
                case 3: {
                    CRUDAlgorithmicTask.updateAlgorithmicTask();
                    break;
                }
                case 4: {
                    CRUDAlgorithmicTask.deleteAlgorithmicTask();
                    break;
                }
                case 5: {
                    AlgorithmicTasksStorage.writeAllTasksFull();
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

    public static void showAlgorithmicTasksMenu() {
        System.out.println("\n===Задания по алгоритмике===");
        System.out.println("1. Создать задание по алгоритмике");
        System.out.println("2. Достать задание по алгоритмике");
        System.out.println("3. Обновить задание по алгоритмике");
        System.out.println("4. Удалить задание по алгоритмике");
        System.out.println("5. Вывод всех заданий по алгоритмике");
        System.out.println("0. Выход");
        System.out.print("Выберите опцию: ");
    }
}
