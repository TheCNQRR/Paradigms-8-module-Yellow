package AlgorithmicTask;

import java.util.ArrayList;

public class AlgorithmicTasksStorage {
    private static final ArrayList<AlgorithmicTask> algorithmicTasks = new ArrayList<>();
    public static ArrayList<AlgorithmicTask> getAlgorithmicTasks() { return algorithmicTasks; }
    public static void addAlgorithmicTask(AlgorithmicTask task) { algorithmicTasks.add(task); }
    public static void removeAlgorithmicTaskAtIndex(int index) { algorithmicTasks.remove(index); }
    public static void removeAlgorithmicTaskObject(AlgorithmicTask task) { algorithmicTasks.remove(task); }
    public static void replaceAlgorithmicTask(int index, AlgorithmicTask task) { algorithmicTasks.set(index, task); }
    public static void writeAllTasks() {
        if (algorithmicTasks.isEmpty()) {
            System.out.println("Список заданий по алгоритмике пуст!");
        }
        else {
            for (int i = 0; i < algorithmicTasks.size(); ++i) {
                System.out.println("Задание " + (i + 1) + ": " + algorithmicTasks.get(i).getName());
            }
        }
    }

    public static void writeAllTasksFull() {
        if (algorithmicTasks.isEmpty()) {
            System.out.println("Список заданий по алгоритмике пуст!");
        }
        else {
            for (int i = 0; i < algorithmicTasks.size(); ++i) {
                System.out.println("{");
                System.out.println("Задание " + (i + 1) + ": " + algorithmicTasks.get(i).getName());
                System.out.println("Текст задания: " + algorithmicTasks.get(i).getTaskText());
                System.out.println("Пример: " + algorithmicTasks.get(i).getTaskExample());
                if (algorithmicTasks.get(i).getProgrammingLanguage().isEmpty()) {
                    System.out.println("Список языков программирования пуст");
                }
                else {
                    System.out.println("Языки программирования:");
                    algorithmicTasks.get(i).writeLanguagesInTask();
                }
                System.out.println("}");
            }
        }
    }
}
