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
@Table(name = "leilao")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SequenceGenerator(name = "leilao_id_seq", sequenceName = "leilao_id_seq", allocationSize = 1)
public class Leilao implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leilao_id_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "codigo")
    private Integer codigo;

    @NotNull
    @Column(name = "descricao")
    private String descricao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "vendedor")
    private Empresa vendedor;

    @NotNull
    @Column(name = "inicio_previsto")
    private Instant inicioPrevisto;

    @NotNull
    @Column(name = "created_at")
    private Instant createdAt;

    @NotNull
    @Column(name = "updated_at")
    private Instant updatedAt;
}
