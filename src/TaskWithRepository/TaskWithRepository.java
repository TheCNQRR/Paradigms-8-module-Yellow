package TaskWithRepository;

import Task.Task;

public class TaskWithRepository extends Task {
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    private String repositoryReference;
    public void setRepositoryReference(String repositoryReference) { this.repositoryReference = repositoryReference; }
    public String getRepositoryReference() { return repositoryReference; }

    public void writeTaskWithRepository() {
        System.out.println("Задание: " + getName());
        System.out.println("Ссылка на репозиторий: " + getRepositoryReference());
        System.out.println("Текст задания: " + getTaskText());
        System.out.println("Пример: " + getTaskExample());
    }
}