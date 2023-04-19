package org.acme;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/tasks")
public class TaskResource {
    private Set<Task> tasks = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    @GET
    public Set<Task> list() {
        return tasks;
    }

    @POST
    public void add(@Valid Task task) {
        tasks.add(task);
    }
}