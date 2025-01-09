package com.techtrack.backend.dto;

import com.techtrack.backend.Application.model.ApplicationStatusEnum;
import jakarta.validation.constraints.NotNull;

public class ApplicationStatusRequestDTO {
    @NotNull(message = "Status is required")
    private ApplicationStatusEnum applicationStatus;

    public ApplicationStatusEnum getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatusEnum applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}
