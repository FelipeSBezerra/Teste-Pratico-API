package com.felipe.entity.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;

public record UnidadeRequestDto(
        @NotNull @Size(max = 128) String nome

) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
