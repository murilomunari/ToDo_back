package com.ToDo.DTO;

import com.ToDo.Model.Enum.TaskPriority;
import com.ToDo.Model.Enum.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskCreateRequest(
                                @NotBlank
                                String title,
                                @NotBlank
                                String category,

                                String description,
                                @NotNull
                                TaskPriority priority
    ) {
}
