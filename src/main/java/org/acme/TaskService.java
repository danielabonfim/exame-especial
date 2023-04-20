package org.acme;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class TaskService {
    @Inject
    TaskDAO taskDAO;

    public void save(Task task) {
        taskDAO.save(task);
    }

    public List<Task> listAll() {
        return taskDAO.list();
    }

    public List<Task> filterByStatus(TaskStatus taskStatus) {
        return taskDAO.filterByStatus(taskStatus);
    }
}
