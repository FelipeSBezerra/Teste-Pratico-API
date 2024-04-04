package com.felipe.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public record LoteResponseDto(
        Integer id,
        Integer numeroLote,
        String descricao,
        Float quantidade,
        Double valorInicial,
        String unidade,
        Integer leilaoId,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
        Instant createdAt,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
        Instant updatedAt
) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
