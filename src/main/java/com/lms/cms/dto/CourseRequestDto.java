package com.lms.cms.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CourseRequestDto(
        @NotBlank(message = "Course name is required")
        @Size(min = 3, max=100,message = "Name must be 3 to 4 characters")
        String name,

        @NotBlank(message = "Description must be required")
        @Size(max = 500,message = "Description cannot exceed 500 characters")
        String description,

        @NotNull(message = "price is required")
        @Min(value = 0,message = "Price cannot be negetive")
        Integer price
) {

}
