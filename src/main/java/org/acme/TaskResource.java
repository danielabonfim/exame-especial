package org.acme;

import java.util.List;

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
    public List<Task> list() {
        return taskService.filterByStatus(null);
    }

    @POST
    public void add(@Valid Task task) {
        taskService.createTask(task);
    }
}