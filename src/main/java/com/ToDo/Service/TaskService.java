package com.ToDo.Service;

import com.ToDo.DTO.TaskCreateRequest;
import com.ToDo.Model.Enum.TaskStatus;
import com.ToDo.Model.Task;
import com.ToDo.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public Task updateTask (String id, TaskStatus newStatus) {
        Task task = taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Task não encontrada!"));

        TaskStatus currentStatus = task.getStatus();

        if (currentStatus == TaskStatus.COMPLETED){
            throw new RuntimeException("Essa tarefa ja foi finalizada!");
        }

        if (currentStatus == TaskStatus.PENDING && newStatus == TaskStatus.COMPLETED) {
            throw new RuntimeException("Coloque a tarefa em progresso!");
        }

        if (currentStatus == TaskStatus.IN_PROGRESS && newStatus == TaskStatus.COMPLETED){
            task.setDateCompletion(LocalDateTime.now());
        } else {
            task.setDateCompletion(null);
        }

        return taskRepository.save(task);
    }

    public void deleteByTitle(String title) {
        Task task = taskRepository.findByTitleContainingIgnoreCase(title)
                .orElseThrow(() -> new RuntimeException("Task não encontrada!"));

        taskRepository.delete(task);
    }

}
