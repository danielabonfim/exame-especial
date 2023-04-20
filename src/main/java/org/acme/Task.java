package org.acme;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Size(min = 5, max = 20, message = "The task's title should have 5 characters at least and 20 at most")
    private String title;

    @Size(min = 5, max = 20, message = "The task's description should have 5 characters at least and 200 at most")
    private String description;

    @FutureOrPresent(message = "The task's starting time should not occur in the past")
    private LocalDateTime startTime;

    @FutureOrPresent(message = "The task's due time should not occur in the past")
    private LocalDateTime dueTime;

    private boolean done;

    public Task() {

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

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isDone() {
        return this.done;
    }
}
