package Solution;

import Task.Task;

import java.util.ArrayList;

public class Solution {
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    private final ArrayList<Task> tasks = new ArrayList<>();
    public ArrayList<Task> getTask() { return new ArrayList<>(tasks); }
    public void addTask(Task task) { tasks.add(task); }
    public void removeTask(int index) { tasks.remove(index); }
    public void writeTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Список заданий пуст!");
        }
        else {
            for (int i = 0; i < tasks.size(); ++i) {
                System.out.println("Задание " + (i + 1) + ": " + tasks.get(i).getName());
            }
        }
    }

    private String solutionText;
    public void setSolutionText(String solutionText) { this.solutionText = solutionText; }
    public String getSolutionText() { return solutionText; }

    public void writeSolution() {
        System.out.println("Информация о решении:");
        System.out.println("Название " + getName());
        System.out.println("Текст решения: " + getSolutionText());
        if (tasks.isEmpty()) {
            System.out.println("Список заданий, к которым прикреплено решение пуст");
        }
        else {
            System.out.println("Список заданий, к которым прикреплено решение:");
            System.out.println("{");
            for (int i = 0; i < tasks.size(); ++i) {
                System.out.println("Задание " + (i + 1) + ": " + tasks.get(i).getName());
            }
            System.out.println("}");
        }
    }
}