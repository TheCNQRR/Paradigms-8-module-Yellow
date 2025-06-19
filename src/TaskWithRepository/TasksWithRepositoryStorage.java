package TaskWithRepository;

import AlgorithmicTask.AlgorithmicTask;

import java.util.ArrayList;

public class TasksWithRepositoryStorage {
    private static final ArrayList<TaskWithRepository> tasksWithRepository = new ArrayList<>();
    public static ArrayList<TaskWithRepository> getTasksWithRepository() { return tasksWithRepository; }
    public static void addTaskWithRepository(TaskWithRepository taskWithRepository) { tasksWithRepository.add(taskWithRepository); }
    public static void removeTaskWithRepositoryAtIndex(int index) { tasksWithRepository.remove(index); }
    public static void removeTaskWithRepositoryObject(TaskWithRepository taskWithRepository) { tasksWithRepository.remove(taskWithRepository); }
    public static void replaceTaskWithRepository(int index, TaskWithRepository task) { tasksWithRepository.set(index, task); }
    public static void writeAllTasks() {
        if (tasksWithRepository.isEmpty()) {
            System.out.println("Список заданий с репозиторием пуст!");
        }
        else {
            for (int i = 0; i < tasksWithRepository.size(); ++i) {
                System.out.println("Задание " + (i + 1) + ": " + tasksWithRepository.get(i).getName());
            }
        }
    }
    public static void writeAllTasksFull() {
        if (tasksWithRepository.isEmpty()) {
            System.out.println("Список заданий с репозиторием пуст!");
        }
        else {
            for (int i = 0; i < tasksWithRepository.size(); ++i) {
                System.out.println("{");
                System.out.println("Задание " + (i + 1) + ": " + tasksWithRepository.get(i).getName());
                System.out.println("Текст задания: " + tasksWithRepository.get(i).getTaskText());
                System.out.println("Пример: " + tasksWithRepository.get(i).getTaskExample());
                System.out.println("}");
            }
        }
    }
}
