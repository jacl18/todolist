package org.generation.todolist.service;

import org.generation.todolist.repository.TodoRepository;
import org.generation.todolist.repository.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TodoServiceMySQL implements TodoService {

    private final TodoRepository todoRepository;


    //constructor
    public TodoServiceMySQL(@Autowired TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    //methods
    @Override
    public Todo save(Todo todo) {

        return this.todoRepository.save(todo);
    }


    @Override
    public void delete(int id) {

        this.todoRepository.deleteById(id);
    }

    @Override
    public ArrayList<Todo> all() {

        ArrayList<Todo> result = new ArrayList<>();
        todoRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Todo findById(int id) {
        Optional<Todo> todo = todoRepository.findById(id);
        Todo resp = todo.get();
        return resp;
    }


}//End of TodoServiceMySQL
