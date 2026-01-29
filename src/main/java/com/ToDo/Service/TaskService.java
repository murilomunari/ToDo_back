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

        if (taskRepository.existsByTitle(data.title())) {
            throw new RuntimeException("Task ja cadestrada!");
        }

        if (data.title() != null && data.title().length() > 100) {
            throw new RuntimeException("Titulo esta muito grande!");
        }

        Task task = Task.builder()
                .title(data.title())
                .category(data.category())
                .description(data.description())
                .build();

        String category = (data.category() == null || data.category().isBlank())
                ? "GENERAL"
                : data.category();
        task.setCategory(category);


        if (data.priority() == null) {
            throw new RuntimeException("Prioridade é obrigatória");
        }
        task.setPriority(data.priority());


        return taskRepository.save(task);
    }
}
