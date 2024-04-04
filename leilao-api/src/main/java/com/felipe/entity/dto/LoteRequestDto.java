package com.felipe.entity.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;

public record LoteRequestDto(
        Integer numeroLote,
        @NotNull @Size(max = 60) String descricao,
        @NotNull Float quantidade,
        Double valorInicial,
        @NotNull @Size(max = 128) String unidade,
        @NotNull Integer leilaoId

) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
