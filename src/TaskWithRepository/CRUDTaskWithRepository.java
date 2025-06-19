package TaskWithRepository;

import AlgorithmicTask.AlgorithmicTask;
import Task.TasksStorage;

import java.util.Scanner;

import static ProgramSystem.Utils.readIntInput;

//TODO интеграция в родительский класс

public class CRUDTaskWithRepository {
    public static void createTaskWithRepository() {
        Scanner scanner = new Scanner(System.in);

        TaskWithRepository taskWithRepository = new TaskWithRepository();

        System.out.print("Введите название задания с репозиторием: ");
        String name = scanner.nextLine();
        taskWithRepository.setName(name);

        System.out.print("Введите ссылку на репозиторий: ");
        String reference = scanner.nextLine();
        taskWithRepository.setRepositoryReference(reference);

        System.out.print("Введите текст задания: ");
        String taskText = scanner.nextLine();
        taskWithRepository.setTaskText(taskText);

        System.out.print("Введите пример: ");
        String taskExample = scanner.nextLine();
        taskWithRepository.setTaskExample(taskExample);

        TasksWithRepositoryStorage.addTaskWithRepository(taskWithRepository);
        TasksStorage.addTask(taskWithRepository);
        System.out.println("Задание с репозиторием добавлено!");
    }

    public static void retrieveTaskWithRepository() {
        if (TasksWithRepositoryStorage.getTasksWithRepository().isEmpty()) {
            System.out.println("Список заданий с репозиторием пуст!");
            return;
        }

        TasksWithRepositoryStorage.writeAllTasks();

        System.out.print("Введите номер задания, которое хотите достать: ");
        int choice = readIntInput();

        if (choice < 1 || choice > TasksWithRepositoryStorage.getTasksWithRepository().size()) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        TasksWithRepositoryStorage.getTasksWithRepository().get(choice - 1).writeTaskWithRepository();
    }

    public static void updateTaskWithRepository() {
        if (TasksWithRepositoryStorage.getTasksWithRepository().isEmpty()) {
            System.out.println("Список заданий с репозиторием пуст!");
            return;
        }

        TasksWithRepositoryStorage.writeAllTasks();
        System.out.print("Введите номер задания, которое хотите обновить: ");
        int choice = readIntInput();

        if (choice > TasksWithRepositoryStorage.getTasksWithRepository().size() || choice < 1) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        System.out.println("Что вы хотите обновить?");
        System.out.println("1. Название задания");
        System.out.println("2. Ссылку на репозиторий");
        System.out.println("3. Текст задания");
        System.out.println("4. Пример");
        System.out.println("0. Выход");
        System.out.print("Выберите опцию: ");

        int option = readIntInput();

        Scanner scanner = new Scanner(System.in);

        TaskWithRepository newTaskWithRepository = TasksWithRepositoryStorage.getTasksWithRepository().get(choice - 1);
        switch (option) {
            case 1: {
                System.out.print("Введите новое название: ");
                String newName = scanner.nextLine();
                newTaskWithRepository.setName(newName);
                TasksWithRepositoryStorage.replaceTaskWithRepository(choice - 1, newTaskWithRepository);
                System.out.println("Задание обновлено!");
                break;
            }
            case 2: {
                System.out.print("Введите новую ссылку на репозиторий: ");
                String newReference = scanner.nextLine();
                newTaskWithRepository.setName(newReference);
                TasksWithRepositoryStorage.replaceTaskWithRepository(choice - 1, newTaskWithRepository);
                System.out.println("Задание обновлено!");
                break;
            }
            case 3: {
                System.out.print("Введите новый текст задания: ");
                String newTaskText = scanner.nextLine();
                newTaskWithRepository.setTaskText(newTaskText);
                TasksWithRepositoryStorage.replaceTaskWithRepository(choice - 1, newTaskWithRepository);
                System.out.println("Задание обновлено!");
                break;
            }
            case 4: {
                System.out.print("Введите новый пример: ");
                String newTaskExample = scanner.nextLine();
                newTaskWithRepository.setTaskExample(newTaskExample);
                TasksWithRepositoryStorage.replaceTaskWithRepository(choice - 1, newTaskWithRepository);
                System.out.println("Задание обновлено!");
                break;
            }
            case 0: {
                return;
            }
            default: {
                System.out.println("Ошибка, вы ввели неверную команду!");
            }
        }
    }

    public static void deleteTaskWithRepository() {
        if (TasksWithRepositoryStorage.getTasksWithRepository().isEmpty()) {
            System.out.println("Список заданий с репозиторием пуст!");
            return;
        }

        TasksWithRepositoryStorage.writeAllTasks();

        System.out.print("Введите номер задания, которое хотите удалить: ");
        int choice = readIntInput();

        if (choice > TasksWithRepositoryStorage.getTasksWithRepository().size() || choice < 1) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        TasksWithRepositoryStorage.removeTaskWithRepositoryAtIndex(choice - 1);
        System.out.println("Задание удалено!");
    }
}
