package com.felipe.entity.mapper;

import com.felipe.entity.Empresa;
import com.felipe.entity.dto.EmpresaRequestDto;
import com.felipe.entity.dto.EmpresaResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class EmpresaMapper {
    public EmpresaResponseDto toResponseDto(Empresa empresa) {
        return new EmpresaResponseDto(
                empresa.getId(),
                empresa.getRazaoSocial(),
                empresa.getCnpj(),
                empresa.getLogradouro(),
                empresa.getNumero(),
                empresa.getComplemento(),
                empresa.getBairro(),
                empresa.getCep(),
                empresa.getTelefone(),
                empresa.getEmail(),
                empresa.getSite(),
                empresa.getUsuario(),
                empresa.getSenha(),
                empresa.getCreatedAt(),
                empresa.getUpdatedAt()
        );
    }

    public Empresa toEmpresa(EmpresaRequestDto requestDto) {
        return Empresa.builder()
                .razaoSocial(requestDto.razaoSocial())
                .cnpj(requestDto.cnpj())
                .logradouro(requestDto.logradouro())
                .numero(requestDto.numero())
                .complemento(requestDto.complemento())
                .bairro(requestDto.bairro())
                .cep(requestDto.cep())
                .telefone(requestDto.telefone())
                .email(requestDto.email())
                .site(requestDto.site())
                .usuario(requestDto.usuario())
                .senha(requestDto.senha())
                .leiloes(new ArrayList<>())
                .build();
    }
}
