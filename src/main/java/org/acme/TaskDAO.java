package org.acme;

import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class TaskDAO {
    @Inject
    EntityManager entityManager;

    public TaskDAO() {

    }

    @Transactional
    public Task get(UUID identifier) {
        return entityManager.find(Task.class, identifier);
    }

    @Transactional
    public void delete(Task task) {
        entityManager.remove(entityManager.contains(task) ? task : entityManager.merge(task));
    }

    @Transactional
    public void save(Task task) {
        if (task.getIdentifier() == null) {
            entityManager.persist(task);
        } else {
            entityManager.merge(task);
        }
    }

    private Query getQueryForStatus(TaskStatus taskStatus) {
        String whereClause = "";

        if (taskStatus.equals(TaskStatus.Concluded)) {
            whereClause = "task.done = True";
        }

        if (taskStatus.equals(TaskStatus.Late)) {
            whereClause = "task.done = False AND task.dueDate < current_date";
        }

        if (taskStatus.equals(TaskStatus.Pending)) {
            whereClause = "task.done = False";
        }

        return entityManager.createQuery("SELECT task FROM Task task WHERE " + whereClause);
    }

    @Transactional
    public List<Task> filterByStatus(TaskStatus taskStatus) {
        Query query = getQueryForStatus(taskStatus);

        return query.getResultList();
    }

    @Transactional
    public List<Task> list() {
        return entityManager.createQuery("SELECT task FROM Task task").getResultList();
    }
}
