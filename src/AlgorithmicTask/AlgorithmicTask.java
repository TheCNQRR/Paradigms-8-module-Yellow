package AlgorithmicTask;

import ProgrammingLanguage.ProgrammingLanguage;
import Task.Task;

import java.util.ArrayList;

public class AlgorithmicTask extends Task {
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    private final ArrayList<ProgrammingLanguage> programmingLanguages = new ArrayList<>();
    public void addProgrammingLanguage(ProgrammingLanguage programmingLanguage) { this.programmingLanguages.add(programmingLanguage); }
    public ArrayList<ProgrammingLanguage> getProgrammingLanguage() { return new ArrayList<>(programmingLanguages); }
    public void removeProgrammingLanguageAtIndex(int index) { programmingLanguages.remove(index); }
    public void writeLanguagesInTask() {
        if (programmingLanguages.isEmpty()) {
            System.out.println("Список языков по программированию пуст");
        }
        else {
            for (int i = 0; i < programmingLanguages.size(); ++i) {
                System.out.println("Язык " + (i + 1) + programmingLanguages.get(i).getName());
            }
        }
    }
    public void writeAlgorithmicTask() {
        System.out.println("Задание: " + getName());
        System.out.println("Текст задания: " + getTaskText());
        System.out.println("Пример: " + getTaskExample());
        if (programmingLanguages.isEmpty()) {
            System.out.println("Список языков по программированию пуст");
        }
        else {
            System.out.println("Языки программирования: ");
            for (int i = 0; i < programmingLanguages.size(); ++i) {
                System.out.println("Язык " + (i + 1) + programmingLanguages.get(i).getName());
            }
        }
    }
}