package org.acme;

import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class TaskService {
    @Inject
    TaskDAO taskDAO;

    public Task save(Task task) {
        return taskDAO.save(task);
    }

    public Task get(UUID identifier) {
        return taskDAO.get(identifier);
    }

    public void delete(UUID identifier) {
        Task task = taskDAO.get(identifier);

        taskDAO.delete(task);
    }

    public List<Task> listAll() {
        return taskDAO.list();
    }

    public List<Task> filterByStatus(TaskStatus taskStatus) {
        return taskDAO.filterByStatus(taskStatus);
    }
}
