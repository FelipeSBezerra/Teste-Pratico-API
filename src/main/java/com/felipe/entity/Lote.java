package com.felipe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "lote")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SequenceGenerator(name = "lote_id_seq", sequenceName = "lote_id_seq", allocationSize = 1)
public class Lote implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lote_id_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "numero_lote")
    private Integer numeroLote;

    @NotNull
    @Column(name = "descricao")
    private String descricao;

    @NotNull
    @Column(name = "quantidade")
    private Float quantidade;

    @Column(name = "valor_inicial")
    private Double valorInicial;

    @Column(name = "unidade")
    private String unidade;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "leilao")
    private Leilao leilao;

    @NotNull
    @Column(name = "created_at")
    private Instant createdAt;

    @NotNull
    @Column(name = "updated_at")
    private Instant updatedAt;
}
