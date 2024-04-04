package com.felipe.business;

import com.felipe.entity.Empresa;
import com.felipe.entity.dto.EmpresaRequestDto;
import com.felipe.entity.dto.EmpresaResponseDto;

import java.util.List;

public interface EmpresaBO {

    EmpresaResponseDto buscarPorId(Integer id);
    Empresa buscarPorIdRetornoEmpresa(Integer id);
    List<EmpresaResponseDto> buscarTodos();
    EmpresaResponseDto criar(EmpresaRequestDto requestDto);
    EmpresaResponseDto atualizar(Integer id, EmpresaRequestDto requestDto);
    void deletar(Integer id);
}
