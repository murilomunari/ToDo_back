package com.ToDo.DTO;

import com.ToDo.Model.Enum.TaskPriority;
import jakarta.validation.constraints.NotBlank;

public record TaskUpdateRequest(
        @NotBlank String title,
        @NotBlank String category,
        String description,
        TaskPriority priority
) {}
