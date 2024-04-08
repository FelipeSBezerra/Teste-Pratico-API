package com.felipe.entity.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public record LeilaoRequestDto(
        Integer codigo,
        @NotNull @Size(max = 60) String descricao,
        @NotNull Integer vendedorId,
        @NotNull Instant inicioPrevisto
) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
