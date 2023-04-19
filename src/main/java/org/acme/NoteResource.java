package org.acme;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/notes")
public class NoteResource {
    private Set<Note> notes = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    @GET
    public Set<Note> list() {
        return notes;
    }

    @POST
    public void add(Note note) {
        notes.add(note);
    }
}