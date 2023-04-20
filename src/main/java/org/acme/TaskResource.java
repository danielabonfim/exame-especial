package org.acme;

import java.util.List;
import org.jboss.resteasy.reactive.RestQuery;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/tasks")
public class TaskResource {
    @Inject
    private TaskService taskService;

    @GET
    public List<Task> list(@RestQuery String taskStatus) {
        System.out.println("GET");
        System.out.println(taskStatus);

        if (taskStatus != null) {
            return taskService.filterByStatus(TaskStatus.valueOf(taskStatus));
        }

        return taskService.listAll();
    }

    @POST
    public void add(@Valid Task task) {
        taskService.createTask(task);
    }
}