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
@Table(name = "empresa")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SequenceGenerator(name = "empresa_id_seq", sequenceName = "empresa_id_seq", allocationSize = 1)
public class Empresa implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa_id_seq")
    @Column(name = "id")
    private Integer id;
    @NotNull
    @Column(name = "razao_social")
    private String razaoSocial;
    @NotNull
    @Column(name = "cnpj",unique = true)
    private String cnpj;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "numero")
    private String numero;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cep")
    private String cep;
    @Column(name = "telefone")
    private String telefone;
    @NotNull
    @Column(name = "email")
    private String email;
    @Column(name = "site")
    private String site;
    @NotNull
    @Column(name = "usuario", unique = true)
    private String usuario;
    @Column(name = "senha")
    private String senha;
    @NotNull
    @Column(name = "created_at")
    private Instant createdAt;
    @NotNull
    @Column(name = "updated_at")
    private Instant updatedAt;
}
