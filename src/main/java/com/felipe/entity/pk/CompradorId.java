package com.felipe.entity.pk;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CompradorId implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer empresaId;
    private Integer leilaoId;
}
