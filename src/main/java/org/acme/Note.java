package org.acme;

import java.time.LocalDateTime;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;

public class Note {
    @Size(min = 5, max = 20, message = "The note's title should have 5 characters at least and 20 at most")
    private String title;

    @Size(min = 5, max = 20, message = "The note's description should have 5 characters at least and 200 at most")
    private String description;

    @FutureOrPresent(message = "The note's starting time should not occur in the past")
    private LocalDateTime startTime;

    @FutureOrPresent(message = "The note's due time should not occur in the past")
    private LocalDateTime dueTime;

    public Note() {

    }

    public Note(String title, String description, LocalDateTime startTime, LocalDateTime dueTime) {
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.dueTime = dueTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public void setDueTime(LocalDateTime dueTime) {
        this.dueTime = dueTime;
    }

    public LocalDateTime getDueTime() {
        return this.dueTime;
    }
}
