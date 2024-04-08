package com.felipe.entity.dto;

import java.io.Serial;
import java.io.Serializable;

public record CompradorResponseDto(
        Integer empresaCompradorId,
        String razaoSocialEmpresaComprador,
        Integer leilaoId

) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
