package com.felipe.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public record LeilaoResponseDto(
        Integer id,
        Integer codigo,
        String descricao,
        EmpresaResponseDtoMin vendedor,
        Instant inicioPrevisto,
        Double valorTotal,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
        Instant createdAt,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
        Instant updatedAt
) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
