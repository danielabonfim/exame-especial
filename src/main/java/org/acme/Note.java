package org.acme;

import java.time.LocalDateTime;

public class Note {
    private String title;
    private String description;

    private LocalDateTime startTime;
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
