package com.ToDo.Controller;

import com.ToDo.DTO.TaskCreateRequest;
import com.ToDo.Model.Task;
import com.ToDo.Service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> create (@RequestBody TaskCreateRequest data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(data));
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findAll());
    }

    @GetMapping("{title}")
    public ResponseEntity<List<Task>> findByTitle(@RequestParam String title) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findByTitle(title));
    }
}
