package com.ToDo.Service;

import com.ToDo.DTO.TaskCreateRequest;
import com.ToDo.Model.Enum.TaskStatus;
import com.ToDo.Model.Task;
import com.ToDo.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(TaskCreateRequest data) {

        if (taskRepository.existsByTitle(data.title())) {
            throw new RuntimeException("Task já cadastrada!");
        }

        Task task = Task.builder()
                .title(data.title())
                .category(data.category())
                .description(data.description())
                .priority(data.priority())
                .status(TaskStatus.PENDING)
                .build();

        return taskRepository.save(task);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findByTitle (String title) {
        return taskRepository.findByTitleContainingIgnoreCase(title);
    }

    public void deleteByTitle(String title) {
        Task task = taskRepository.findByTitleContainingIgnoreCase(title)
                .orElseThrow(() -> new RuntimeException("Task não encontrada"));

        taskRepository.delete(task);
    }

}
