package com.ToDo.DTO;

import com.ToDo.Model.Enum.TaskPriority;
import com.ToDo.Model.Enum.TaskStatus;

import java.time.LocalDateTime;

public record TaskResponse(
        String id,
        String title,
        String category,
        String description,
        TaskStatus status,
        TaskPriority priority,
        LocalDateTime dateCreation,
        LocalDateTime dateCompletion
) {}
