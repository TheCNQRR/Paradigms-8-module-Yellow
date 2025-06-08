package TaskWithRepository;

import java.util.ArrayList;

public class TasksWithRepositoryStorage {
    private static final ArrayList<TaskWithRepository> tasksWithRepository = new ArrayList<>();
    public static ArrayList<TaskWithRepository> getTasksWithRepository() { return tasksWithRepository; }
    public static void addTaskWithRepository(TaskWithRepository taskWithRepository) { tasksWithRepository.add(taskWithRepository); }
    public static void removeTaskWithRepositoryAtIndex(int index) { tasksWithRepository.remove(index); }
    public static void removeTaskWithRepositoryObject(TaskWithRepository taskWithRepository) { tasksWithRepository.remove(taskWithRepository); }
}
