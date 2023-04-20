package org.acme;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.persistence.Query;

@ApplicationScoped
public class TaskService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public void createTask(Task task) {
        entityManager.persist(task);
    }

    @Transactional
    public List<Task> filterByStatus(String status) {
        Query query = entityManager.createQuery("SELECT task FROM Task task WHERE task.title = 'nota 1'");

        List<Task> list = (List<Task>) query.getResultList();

        return list;
    }
}
