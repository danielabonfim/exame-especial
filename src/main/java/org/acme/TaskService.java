package org.acme;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class TaskService {
    @Inject
    TaskDAO taskDAO;

    @Transactional
    public void createTask(Task task) {
        taskDAO.create(task);
    }

    @Transactional
    public List<Task> listAll() {
        return taskDAO.list();
    }

    @Transactional
    public List<Task> filterByStatus(TaskStatus taskStatus) {
        return taskDAO.filterByStatus(taskStatus);
    }
}
