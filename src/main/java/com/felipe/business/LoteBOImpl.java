package com.felipe.business;

import com.felipe.business.exception.ResourceNotFoundException;
import com.felipe.entity.Leilao;
import com.felipe.entity.Lote;
import com.felipe.entity.dto.LoteRequestDto;
import com.felipe.entity.dto.LoteResponseDto;
import com.felipe.entity.mapper.LoteMapper;
import com.felipe.repository.LoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LoteBOImpl implements LoteBO{

    private final LoteRepository loteRepository;
    private final LoteMapper loteMapper;
    private final LeilaoBO leilaoBO;

    @Override
    public LoteResponseDto buscarPorId(Integer id) {
        return loteMapper.toResponseDto(this.buscarPorIdRetornoLote(id));
    }

    @Override
    public List<LoteResponseDto> buscarTodos() {
        return loteRepository.findAll()
                .stream().map(loteMapper::toResponseDto).collect(Collectors.toList());
    }

    @Override
    public LoteResponseDto criar(LoteRequestDto requestDto) {
        Lote novoLote = this._criarInstanciaLote(requestDto);
        novoLote.setCreatedAt(Instant.now());
        novoLote.setUpdatedAt(Instant.now());
        return loteMapper.toResponseDto(loteRepository.save(novoLote));
    }

    @Override
    public LoteResponseDto atualizar(Integer id, LoteRequestDto requestDto) {
        Lote loteSalvo= this.buscarPorIdRetornoLote(id);
        return loteMapper.toResponseDto(
                loteRepository.save(this._atualizarDados(loteSalvo, requestDto))
        );
    }

    @Override
    public void deletar(Integer id) {
        buscarPorIdRetornoLote(id);
        loteRepository.deleteById(id);
    }

    private Lote _criarInstanciaLote(LoteRequestDto requestDto) {
        Leilao leilao = leilaoBO.buscarPorIdRetornoLeilao(requestDto.leilaoId());
        return loteMapper.toLote(requestDto, leilao);
    }

    @Override
    public Lote buscarPorIdRetornoLote(Integer id) {
        return loteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                String.format("Não há um Lote com o ID = %d na base de dados.", id)));
    }

    private Lote _atualizarDados(Lote loteSalvo, LoteRequestDto requestDto) {
        Lote loteAtualizada = this._criarInstanciaLote(requestDto);
        loteAtualizada.setId(loteSalvo.getId());
        loteAtualizada.setCreatedAt(loteSalvo.getCreatedAt());
        loteAtualizada.setUpdatedAt(Instant.now());
        return loteAtualizada;
    }
}
