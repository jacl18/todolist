package org.generation.todolist.repository.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.generation.todolist.controller.dto.TodoDTO;

import java.util.Date;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Date date;


    //constructors
    public Todo() {}

    public Todo(TodoDTO todoDTO) {
        this.title = todoDTO.getTitle();
        this.description = todoDTO.getDescription();
        this.date = todoDTO.getDate();
    }


    //getter and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ToDo{" + "id=" + id + ", title='" + title + ", description='" +
                description + ", date='" + date + '}';
    }


}//End of Todo Class
