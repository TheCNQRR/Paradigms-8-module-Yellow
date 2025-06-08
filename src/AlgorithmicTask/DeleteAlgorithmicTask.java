package AlgorithmicTask;

import static ProgramSystem.Utils.readIntInput;

public class DeleteAlgorithmicTask {
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
