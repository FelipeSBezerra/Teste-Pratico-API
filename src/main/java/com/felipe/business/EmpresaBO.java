package com.felipe.business;

import com.felipe.entity.Empresa;
import com.felipe.entity.dto.EmpresaRequestDto;
import com.felipe.entity.dto.EmpresaResponseDto;
import com.felipe.repository.specification.EmpresaSpecification;

import java.util.List;

public interface EmpresaBO {

    EmpresaResponseDto buscarPorId(Integer id);
    Empresa buscarPorIdRetornoEmpresa(Integer id);
    List<EmpresaResponseDto> buscarTodos(EmpresaSpecification specification);
    EmpresaResponseDto criar(EmpresaRequestDto requestDto);
    EmpresaResponseDto atualizar(Integer id, EmpresaRequestDto requestDto);
    void deletar(Integer id);
}
