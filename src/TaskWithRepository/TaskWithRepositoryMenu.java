package TaskWithRepository;

import AlgorithmicTask.AlgorithmicTasksStorage;
import AlgorithmicTask.CRUDAlgorithmicTask;

import static ProgramSystem.Utils.readIntInput;

public class TaskWithRepositoryMenu {
    public static void tasksWithRepositoryMenu() {
        while (true) {
            showTaskWithRepositoryMenu();

            int choice = readIntInput();

            switch(choice) {
                case 1: {
                    CRUDTaskWithRepository.createTaskWithRepository();
                    break;
                }
                case 2: {
                    CRUDTaskWithRepository.retrieveTaskWithRepository();
                    break;
                }
                case 3: {
                    CRUDTaskWithRepository.updateTaskWithRepository();
                    break;
                }
                case 4: {
                    CRUDTaskWithRepository.deleteTaskWithRepository();
                    break;
                }
                case 5: {
                    TasksWithRepositoryStorage.writeAllTasksFull();
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

    public static void showTaskWithRepositoryMenu() {
        System.out.println("\n===Задания с репозиторием===");
        System.out.println("1. Создать задание с репозиторием");
        System.out.println("2. Достать задание с репозиторием");
        System.out.println("3. Обновить задание с репозиторием");
        System.out.println("4. Удалить задание с репозиторием");
        System.out.println("5. Вывод всех заданий с репозиторием");
        System.out.println("0. Выход");
        System.out.print("Выберите опцию: ");
    }
}
