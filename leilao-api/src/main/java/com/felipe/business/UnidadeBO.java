package com.felipe.business;

import com.felipe.entity.Unidade;
import com.felipe.entity.dto.UnidadeRequestDto;
import com.felipe.entity.dto.UnidadeResponseDto;

import java.util.List;

public interface UnidadeBO {

    UnidadeResponseDto buscarPorId(Integer id);
    Unidade buscarPorIdRetornoUnidade(Integer id);
    List<UnidadeResponseDto> buscarTodos();
    UnidadeResponseDto criar(UnidadeRequestDto requestDto);
    UnidadeResponseDto atualizar(Integer id, UnidadeRequestDto requestDto);
    void deletar(Integer id);
}
