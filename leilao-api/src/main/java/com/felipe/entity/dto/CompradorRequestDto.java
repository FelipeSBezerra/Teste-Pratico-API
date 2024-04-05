package com.felipe.entity.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

public record CompradorRequestDto(
        @NotNull Integer empresaCompradorId,
        @NotNull Integer leilaoId

) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
