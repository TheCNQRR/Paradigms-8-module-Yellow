package Task;

import java.util.ArrayList;

public class TasksStorage {
    private static final ArrayList<Task> tasks = new ArrayList<>();
    public static ArrayList<Task> getTasks() { return tasks; }
    public static void addTask(Task task) { tasks.add(task); }
    public static void removeTaskAtIndex(int index) { tasks.remove(index); }
    public static void removeTaskObject(Task task) { tasks.remove(task); }
}
