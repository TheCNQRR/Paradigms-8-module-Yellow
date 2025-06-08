package AlgorithmicTask;

import static ProgramSystem.Utils.readIntInput;

public class RetrieveAlgorithmicTask {
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
}
