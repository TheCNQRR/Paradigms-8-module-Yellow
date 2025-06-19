package CourseModule;

import AlgorithmicTask.AlgorithmicTask;
import Course.Course;
import Survey.Survey;
import Task.Task;
import TaskWithRepository.TaskWithRepository;
import Topic.Topic;

import java.util.ArrayList;

public class CourseModule extends Topic {
    private String moduleName;
    public String getModuleName() { return moduleName; }
    public void setModuleName(String moduleName) { this.moduleName = moduleName; }

    public CourseModule(String topicName, String moduleName, Course course) {
        super(course);
        this.name = topicName;
        this.moduleName = moduleName;
    }

    private CourseModule parent;
    public CourseModule getParent() { return parent; }
    public void setParent(CourseModule parent) { this.parent = parent; }
    public void removeParent() { parent = null; }
    public void removeAllChildren() { children.clear(); }
    public void removeChildrenObject(CourseModule module) { children.remove(module); }

    private final ArrayList<CourseModule> children = new ArrayList<>();
    public ArrayList<CourseModule> getChildren() { return new ArrayList<>(children); }
    public void addChildren(CourseModule children) { this.children.add(children); }
    public void removeChildrenAtIndex(int index) { children.remove(index); }

    public void setVisibilityRecursive(boolean visibility) {
        this.setVisibility(visibility);

        for (CourseModule child : getChildren()) {
            child.setVisibilityRecursive(visibility);
        }
    }

    public void addTask(Task task) { tasks.add(task); }
    public void removeTaskAtIndex(int index) { tasks.remove(index); }
    public void removeTaskObject(Task task) { tasks.remove(task); }
    public ArrayList<Task> getTasks() { return new ArrayList<>(tasks); }
    public void writeAllTasks() {
        for (int i = 0; i < tasks.size(); ++i) {
            Task task = tasks.get(i);
            String type = "";
            if (task instanceof AlgorithmicTask) { type = "задание по алгоритмике"; }
            else if (task instanceof TaskWithRepository) { type = "задание с репозиторием"; }
            else if (task instanceof Survey) { type = "опрос"; }

            System.out.println("{");
            System.out.println("Задание " + (i + 1) + ": " + task.getName() + " [" + type + "]");
            System.out.println("Текст задания: " + task.getTaskText());
            System.out.println("Пример: " + task.getTaskExample());
            if (task instanceof AlgorithmicTask) { ((AlgorithmicTask) task).writeLanguagesInTask(); }
            else if (task instanceof TaskWithRepository) { System.out.println("Ссылка на репозиторий: " + ((TaskWithRepository) task).getRepositoryReference()); }
            else if (task instanceof Survey) {
                System.out.println("Список вопросов: ");
                System.out.println("[");
                ((Survey) task).writeAllQuestions();
                System.out.println("]");
            }
            System.out.println("}");
        }
    }

    @Override
    public String getName() { return name; }

    @Override
    public void setName(String name) { this.name = name; }
}
