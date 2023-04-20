package org.acme;

import java.util.List;
import org.jboss.resteasy.reactive.RestQuery;
import java.util.UUID;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/tasks")
public class TaskResource {
    @Inject
    private TaskService taskService;

    @GET
    public List<Task> list(@RestQuery String taskStatus) {
        if (taskStatus != null) {
            return taskService.filterByStatus(TaskStatus.valueOf(taskStatus));
        }

        return taskService.listAll();
    }

    @POST
    public Task add(@Valid Task task) {
        return taskService.save(task);
    }

    @PUT
    public Task update(@Valid Task task) {
        return taskService.save(task);
    }

    @GET
    @Path("{identifier}")
    public Task get(@PathParam("identifier") UUID identifier) {
        return taskService.get(identifier);
    }

    @DELETE
    @Path("{identifier}")
    public void delete(@PathParam("identifier") UUID identifier) {
        System.out.println("DELETE!");
        System.out.println(identifier);
        taskService.delete(identifier);
    }
}