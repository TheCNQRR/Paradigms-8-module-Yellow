package AlgorithmicTask;

import ProgrammingLanguage.ProgrammingLanguage;
import Task.Task;

public class AlgorithmicTask extends Task {
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    ProgrammingLanguage programmingLanguage;
    public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) { this.programmingLanguage = programmingLanguage; }
    public ProgrammingLanguage getProgrammingLanguage() { return programmingLanguage; }

    public void writeAlgorithmicTask() {
        System.out.println("Задание: " + getName());
        System.out.println("Текст задания: " + getTaskText());
        System.out.println("Пример: " + getTaskExample());
    }
}