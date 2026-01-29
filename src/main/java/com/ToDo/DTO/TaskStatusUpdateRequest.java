package com.ToDo.DTO;

import com.ToDo.Model.Enum.TaskStatus;
import jakarta.validation.constraints.NotNull;

public record TaskStatusUpdateRequest(
        @NotNull TaskStatus status
) {}
