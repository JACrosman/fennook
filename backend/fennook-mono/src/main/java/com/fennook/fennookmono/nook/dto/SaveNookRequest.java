package com.fennook.fennookmono.nook.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class SaveNookRequest {
    private UUID id;
    @NotBlank(message = "Name is required")
    private String name;
    private String description;
}
