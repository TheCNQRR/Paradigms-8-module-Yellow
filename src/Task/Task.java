package Task;

import Solution.Solution;

public abstract class Task {
    protected String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    private String taskText;
    public void setTaskText(String taskText) { this.taskText = taskText; }
    public String getTaskText() { return taskText; }

    private String taskExample;
    public void setTaskExample(String taskExample) { this.taskExample = taskExample; }
    public String getTaskExample() { return taskExample; }
}