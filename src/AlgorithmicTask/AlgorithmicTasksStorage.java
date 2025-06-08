package AlgorithmicTask;

import java.util.ArrayList;

public class AlgorithmicTasksStorage {
    private static final ArrayList<AlgorithmicTask> algorithmicTasks = new ArrayList<>();
    public static ArrayList<AlgorithmicTask> getAlgorithmicTasks() { return algorithmicTasks; }
    public static void addAlgorithmicTask(AlgorithmicTask task) { algorithmicTasks.add(task); }
    public static void removeAlgorithmicTaskAtIndex(int index) { algorithmicTasks.remove(index); }
    public static void removeAlgorithmicTaskObject(AlgorithmicTask task) { algorithmicTasks.remove(task); }
}
