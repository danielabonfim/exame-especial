package org.acme;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.time.LocalDateTime;

@Path("/notes")
public class NoteResource {

    @GET
    public Set<Note> list() {
        Set<Note> notes = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

        notes.add(new Note("Aguar as plantas", "Regar todas as plantas", LocalDateTime.now(), LocalDateTime.now()));

        return notes;
    }
}