package org.generation.todolist.service;
import org.generation.todolist.repository.entity.Todo;
import java.util.ArrayList;

public interface TodoService {

    //this method is for add new task
    Todo save(Todo todo);

    //delete task from database by Id
    void delete(int id);

    //this method is to list all tasks from database
    ArrayList<Todo> all();

    //this is to find a task by Id
    Todo findById(int id);

}//End of TodoService interface
