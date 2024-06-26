package com.felipe.business;

import com.felipe.entity.Leilao;
import com.felipe.entity.dto.LeilaoRequestDto;
import com.felipe.entity.dto.LeilaoResponseDto;
import com.felipe.repository.specification.LeilaoSpecification;

import java.util.List;

public interface LeilaoBO {

    LeilaoResponseDto buscarPorId(Integer id);
    Leilao buscarPorIdRetornoLeilao(Integer id);
    List<LeilaoResponseDto> buscarTodos(LeilaoSpecification specification);
    LeilaoResponseDto criar(LeilaoRequestDto requestDto);
    LeilaoResponseDto atualizar(Integer id, LeilaoRequestDto requestDto);
    void deletar(Integer id);
}
