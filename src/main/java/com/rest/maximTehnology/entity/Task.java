package com.rest.maximTehnology.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String descriptionTask;

    @Column(name = "status")
    private boolean status;

    @Column(name = "date")
    private Date date;

    public int getId() {
        return id;
    }

    public String getDescriptionTask() {
        return descriptionTask;
    }

    public void setDescriptionTask(String descriptionTask) {
        this.descriptionTask = descriptionTask;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && status == task.status && descriptionTask.equals(task.descriptionTask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descriptionTask, status);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", descriptionTask='" + descriptionTask + '\'' +
                ", status=" + status +
                ", date=" + date +
                '}';
    }
}
