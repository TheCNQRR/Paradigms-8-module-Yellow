package TaskWithRepository;

import Task.Task;

public class TaskWithRepository extends Task {
    private String repositoryReference;
    public void setRepositoryReference(String repositoryReference) { this.repositoryReference = repositoryReference; }
    public String getRepositoryReference() { return repositoryReference; }
}