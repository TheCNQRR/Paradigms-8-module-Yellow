package AlgorithmicTask;

import java.util.Scanner;

import static ProgramSystem.Utils.readIntInput;

public class CRUDAlgorithmicTask {
    public static void createAlgorithmicTask() {
        Scanner scanner = new Scanner(System.in);

        AlgorithmicTask algorithmicTask = new AlgorithmicTask();

        System.out.print("Введите название задания по алгоритмике: ");
        String name = scanner.nextLine();
        algorithmicTask.setName(name);

        System.out.print("Введите текст задания: ");
        String taskText = scanner.nextLine();
        algorithmicTask.setTaskText(taskText);

        System.out.print("Введите пример: ");
        String taskExample = scanner.nextLine();
        algorithmicTask.setTaskExample(taskExample);

        AlgorithmicTasksStorage.addAlgorithmicTask(algorithmicTask);
        System.out.println("Задание по алгоритмике добавлено!");
    }

    public static void retrieveAlgorithmicTask() {
        if (AlgorithmicTasksStorage.getAlgorithmicTasks().isEmpty()) {
            System.out.println("Список заданий по алгоритмике пуст!");
            return;
        }

        AlgorithmicTasksStorage.writeAllTasks();

        System.out.print("Введите номер задания, которое хотите достать: ");
        int choice = readIntInput();

        if (choice > AlgorithmicTasksStorage.getAlgorithmicTasks().size() || choice < 1) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        AlgorithmicTasksStorage.getAlgorithmicTasks().get(choice - 1).writeAlgorithmicTask();
    }

    public static void updateAlgorithmicTask() {
        if (AlgorithmicTasksStorage.getAlgorithmicTasks().isEmpty()) {
            System.out.println("Список заданий по алгоритмике пуст!");
            return;
        }

        AlgorithmicTasksStorage.writeAllTasks();
        System.out.print("Введите номер задания, которое хотите обновить: ");
        int choice = readIntInput();

        if (choice > AlgorithmicTasksStorage.getAlgorithmicTasks().size() || choice < 1) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        System.out.println("Что вы хотите обновить?");
        System.out.println("1. Название задания");
        System.out.println("2. Текст задания");
        System.out.println("3. Пример");
        System.out.println("0. Выход");
        System.out.print("Выберите опцию: ");

        int option = readIntInput();

        Scanner scanner = new Scanner(System.in);

        AlgorithmicTask newAlgorithmicTask = AlgorithmicTasksStorage.getAlgorithmicTasks().get(choice - 1);

        switch (option) {
            case 1: {
                System.out.print("Введите новое название: ");
                String newName = scanner.nextLine();
                newAlgorithmicTask.setName(newName);
                AlgorithmicTasksStorage.replaceAlgorithmicTask(choice - 1, newAlgorithmicTask);
                System.out.println("Задание обновлено!");
                break;
            }
            case 2: {
                System.out.print("Введите новый текст задания: ");
                String newTaskText = scanner.nextLine();
                newAlgorithmicTask.setTaskText(newTaskText);
                AlgorithmicTasksStorage.replaceAlgorithmicTask(choice - 1, newAlgorithmicTask);
                System.out.println("Задание обновлено!");
                break;
            }
            case 3: {
                System.out.print("Введите новый пример: ");
                String newTaskExample = scanner.nextLine();
                newAlgorithmicTask.setTaskExample(newTaskExample);
                AlgorithmicTasksStorage.replaceAlgorithmicTask(choice - 1, newAlgorithmicTask);
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

    public static void deleteAlgorithmicTask() {
        if (AlgorithmicTasksStorage.getAlgorithmicTasks().isEmpty()) {
            System.out.println("Список заданий по алгоритмике пуст!");
            return;
        }

        AlgorithmicTasksStorage.writeAllTasks();

        System.out.print("Введите номер задания, которое хотите удалить: ");
        int choice = readIntInput();

        if (choice > AlgorithmicTasksStorage.getAlgorithmicTasks().size() || choice < 1) {
            System.out.println("Ошибка, вы ввели неверный номер!");
            return;
        }

        AlgorithmicTasksStorage.removeAlgorithmicTaskAtIndex(choice - 1);
        System.out.println("Задание удалено!");
    }
}
