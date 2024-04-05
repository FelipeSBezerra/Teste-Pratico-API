package com.felipe.entity;

import com.felipe.entity.pk.CompradorId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "comprador")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comprador implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CompradorId id;

    @MapsId("empresaId")
    @ManyToOne
    @JoinColumn(name = "empresa")
    private Empresa empresa;

    @MapsId("leilaoId")
    @ManyToOne
    @JoinColumn(name = "leilao")
    private Leilao leilao;
}
