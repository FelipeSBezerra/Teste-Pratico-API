package com.felipe.business;

import com.felipe.business.exception.ResourceNotFoundException;
import com.felipe.entity.Unidade;
import com.felipe.entity.dto.UnidadeRequestDto;
import com.felipe.entity.dto.UnidadeResponseDto;
import com.felipe.entity.mapper.UnidadeMapper;
import com.felipe.repository.UnidadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UnidadeBOImpl implements UnidadeBO{

    private final UnidadeRepository unidadeRepository;
    private final UnidadeMapper unidadeMapper;

    @Override
    public UnidadeResponseDto buscarPorId(Integer id) {
        return unidadeMapper.toResponseDto(this.buscarPorIdRetornoUnidade(id));
    }

    @Override
    public List<UnidadeResponseDto> buscarTodos() {
        return unidadeRepository.findAll()
                .stream().map(unidadeMapper::toResponseDto).collect(Collectors.toList());
    }

    @Override
    public UnidadeResponseDto criar(UnidadeRequestDto requestDto) {
        Unidade novaUnidade = new Unidade(null, requestDto.nome(), Instant.now(), Instant.now());
        return unidadeMapper.toResponseDto(unidadeRepository.save(novaUnidade));
    }

    @Override
    public UnidadeResponseDto atualizar(Integer id, UnidadeRequestDto requestDto) {
        Unidade unidadeSalva = this.buscarPorIdRetornoUnidade(id);
        return unidadeMapper.toResponseDto(
                unidadeRepository.save(this._atualizarDados(unidadeSalva, requestDto))
        );
    }

    @Override
    public void deletar(Integer id) {
        buscarPorIdRetornoUnidade(id);
        unidadeRepository.deleteById(id);
    }

    @Override
    public Unidade buscarPorIdRetornoUnidade(Integer id) {
        return unidadeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                String.format("Não há uma Unidade com o ID = %d na base de dados.", id)));
    }

    private Unidade _atualizarDados(Unidade unidadeSalva, UnidadeRequestDto requestDto) {
        return new Unidade(unidadeSalva.getId(), requestDto.nome(), unidadeSalva.getCreatedAt(), Instant.now());
    }
}
