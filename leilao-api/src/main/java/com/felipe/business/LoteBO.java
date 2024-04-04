package com.felipe.business;

import com.felipe.entity.Lote;
import com.felipe.entity.dto.LoteRequestDto;
import com.felipe.entity.dto.LoteResponseDto;

import java.util.List;

public interface LoteBO {

    LoteResponseDto buscarPorId(Integer id);
    Lote buscarPorIdRetornoLote(Integer id);
    List<LoteResponseDto> buscarTodos();
    LoteResponseDto criar(LoteRequestDto requestDto);
    LoteResponseDto atualizar(Integer id, LoteRequestDto requestDto);
    void deletar(Integer id);
}
