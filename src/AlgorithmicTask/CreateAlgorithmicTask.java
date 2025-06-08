package AlgorithmicTask;

import ProgrammingLanguage.ProgrammingLanguage;

import java.util.Scanner;

public class CreateAlgorithmicTask {
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
}
