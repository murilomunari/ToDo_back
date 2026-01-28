package com.ToDo.Service;

import com.ToDo.DTO.TaskCreateRequest;
import com.ToDo.Model.Task;
import com.ToDo.Repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create (TaskCreateRequest data) {
        return null;
    }
}
