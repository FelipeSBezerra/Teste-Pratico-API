package com.felipe.entity.dto;

import java.io.Serial;
import java.io.Serializable;

public record EmpresaResponseDtoMin(
        Integer id,
        String razaoSocial

) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
