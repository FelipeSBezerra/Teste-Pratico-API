package com.felipe.entity.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;

import java.io.Serial;
import java.io.Serializable;

public record EmpresaRequestDto(
        @NotNull @Size(max=64) String razaoSocial,
        @NotNull @CNPJ String cnpj,
        @Size(max=64) String logradouro,
        @Size(max=10) String numero,
        @Size(max=64) String complemento,
        @Size(max=64) String bairro,
        @Size(max=16) String cep,
        @Size(max=32) String telefone,
        @NotNull @Size(max=254) @Email String email,
        @Size(max=254) String site,
        @NotNull @Size(max=20) String usuario,
        @Size(max=128) String senha
) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
