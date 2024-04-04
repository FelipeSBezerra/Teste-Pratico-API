package com.felipe.business;

import com.felipe.business.exception.DataIntegrityViolationException;
import com.felipe.business.exception.ResourceNotFoundException;
import com.felipe.entity.Leilao;
import com.felipe.entity.dto.EmpresaResponseDto;
import com.felipe.entity.dto.LeilaoRequestDto;
import com.felipe.entity.dto.LeilaoResponseDto;
import com.felipe.entity.mapper.LeilaoMapper;
import com.felipe.repository.LeilaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LeilaoBOImpl implements LeilaoBO{

    private final LeilaoRepository leilaoRepository;
    private final LeilaoMapper leilaoMapper;
    private final EmpresaBO empresaBO;

    @Override
    public LeilaoResponseDto buscarPorId(Integer id) {
        return leilaoMapper.toResponseDto(this._buscarPorId(id));
    }

    @Override
    public List<LeilaoResponseDto> buscarTodos() {
        return leilaoRepository.findAll()
                .stream().map(leilaoMapper::toResponseDto).collect(Collectors.toList());
    }

    @Override
    public LeilaoResponseDto criar(LeilaoRequestDto requestDto) {
        EmpresaResponseDto empresaResponseDto = empresaBO.buscarPorId(requestDto.vendedorId());
        Leilao novoLeilao = leilaoMapper.toLeilao(requestDto, empresaResponseDto);
        novoLeilao.setCreatedAt(Instant.now());
        novoLeilao.setUpdatedAt(Instant.now());
        return leilaoMapper.toResponseDto(leilaoRepository.save(novoLeilao));
    }

    @Override
    public LeilaoResponseDto atualizar(Integer id, LeilaoRequestDto requestDto) {
        EmpresaResponseDto empresaResponseDto = empresaBO.buscarPorId(requestDto.vendedorId());
        Leilao leilaoSalvo= this._buscarPorId(id);
        return leilaoMapper.toResponseDto(
                leilaoRepository.save(this._atualizarDados(leilaoSalvo, requestDto, empresaResponseDto))
        );
    }

    @Override
    public void deletar(Integer id) {
        this._verificarIntegridadeAntesExclusao(this._buscarPorId(id));
        leilaoRepository.deleteById(id);
    }

    private Leilao _buscarPorId(Integer id) {
        return leilaoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                String.format("Não há uma Leilão com o ID = %d na base de dados.", id)));
    }


    private Leilao _atualizarDados(Leilao leilaoSalvo, LeilaoRequestDto requestDto, EmpresaResponseDto empresaResponseDto) {
        Leilao leilaoAtualizada = leilaoMapper.toLeilao(requestDto, empresaResponseDto);
        leilaoAtualizada.setId(leilaoSalvo.getId());
        leilaoAtualizada.setCreatedAt(leilaoSalvo.getCreatedAt());
        leilaoAtualizada.setUpdatedAt(Instant.now());
        return leilaoAtualizada;
    }

    private void _verificarIntegridadeAntesExclusao(Leilao leilao) {
        if (!leilao.getLotes().isEmpty()) {
            throw new DataIntegrityViolationException("O Leilão possui Lotes e não pode ser excluído.");
        }
    }
}
