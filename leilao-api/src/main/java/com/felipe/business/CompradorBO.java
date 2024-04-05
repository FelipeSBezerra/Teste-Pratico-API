package com.felipe.business;

import com.felipe.entity.Comprador;
import com.felipe.entity.dto.CompradorRequestDto;
import com.felipe.entity.dto.CompradorResponseDto;

import java.util.List;

public interface CompradorBO {

    CompradorResponseDto buscarPorId(Integer empresaId, Integer leilaoId);
    Comprador buscarPorIdRetornoComprador(Integer empresaId, Integer leilaoId);
    List<CompradorResponseDto> buscarTodos();
    CompradorResponseDto criar(CompradorRequestDto requestDto);
    CompradorResponseDto atualizar(Integer empresaId, Integer leilaoId, CompradorRequestDto requestDto);
    void deletar(Integer empresaId, Integer leilaoId);
}
