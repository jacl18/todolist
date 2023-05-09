package org.generation.todolist.controller;

//this controller is to map the http verb requests to our table

import org.generation.todolist.controller.dto.TodoDTO;
import org.generation.todolist.repository.entity.Todo;
import org.generation.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;


    //Dependency injection
    public TodoController (@Autowired TodoService todoService) {

        this.todoService = todoService;
    }

    //Get all tasks
    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Todo> getTodo() {
        return this.todoService.all();
    }



    //Add new task
    @CrossOrigin
    @PostMapping("/add")
    public void save(@RequestParam(name="title", required = true) String title,
                     @RequestParam(name="description", required = true) String description,
                     @RequestParam(name="date", required = true)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {


        TodoDTO todoDTO = new TodoDTO(title, description, date);
        Todo todo = new Todo(todoDTO);
        this.todoService.save(todo);
    }





}//End of TodoController
