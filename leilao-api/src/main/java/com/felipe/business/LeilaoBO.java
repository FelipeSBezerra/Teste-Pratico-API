package com.felipe.business;

import com.felipe.entity.dto.LeilaoRequestDto;
import com.felipe.entity.dto.LeilaoResponseDto;

import java.util.List;

public interface LeilaoBO {

    LeilaoResponseDto buscarPorId(Integer id);
    List<LeilaoResponseDto> buscarTodos();
    LeilaoResponseDto criar(LeilaoRequestDto requestDto);
    LeilaoResponseDto atualizar(Integer id, LeilaoRequestDto requestDto);
    void deletar(Integer id);
}
