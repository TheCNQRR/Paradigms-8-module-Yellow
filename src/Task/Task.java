package Task;

public abstract class Task {
    private String taskText;
    public void setTaskText(String taskText) { this.taskText = taskText; }
    public String getTaskText() { return taskText; }

    private String taskExample;
    public void setTaskExample(String taskExample) { this.taskExample = taskExample; }
    public String getTaskExample() { return taskExample; }
}