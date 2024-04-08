package com.felipe.business;

import com.felipe.business.exception.BadRequestException;
import com.felipe.business.exception.DataIntegrityViolationException;
import com.felipe.business.exception.ResourceNotFoundException;
import com.felipe.entity.Comprador;
import com.felipe.entity.Empresa;
import com.felipe.entity.Leilao;
import com.felipe.entity.dto.CompradorRequestDto;
import com.felipe.entity.dto.CompradorResponseDto;
import com.felipe.entity.mapper.CompradorMapper;
import com.felipe.entity.pk.CompradorId;
import com.felipe.repository.CompradorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompradorBOImpl implements CompradorBO{

    private final CompradorRepository compradorRepository;
    private final CompradorMapper compradorMapper;
    private final EmpresaBO empresaBO;
    private final LeilaoBO leilaoBO;

    @Override
    public CompradorResponseDto buscarPorId(Integer empresaId, Integer leilaoId) {
        return compradorMapper.toResponseDto(this.buscarPorIdRetornoComprador(empresaId, leilaoId));
    }

    @Override
    public List<CompradorResponseDto> buscarTodos() {
        return compradorRepository.findAll()
                .stream().map(compradorMapper::toResponseDto).collect(Collectors.toList());
    }

    @Override
    public CompradorResponseDto criar(CompradorRequestDto requestDto) {
        CompradorId compradorId = this._gerarCompradorId(requestDto);
        this._verificarIntegridadeAntesCriar(compradorId);
        Comprador novoComprador = this._instanciarComprador(requestDto);
        return compradorMapper.toResponseDto(compradorRepository.save(novoComprador));
    }

    @Override
    public CompradorResponseDto atualizar(Integer empresaId, Integer leilaoId, CompradorRequestDto requestDto) {
        Comprador compradorSalvo = this.buscarPorIdRetornoComprador(empresaId, leilaoId);
        return compradorMapper.toResponseDto(
                compradorRepository.save(this._atualizarDados(compradorSalvo, requestDto))
        );
    }

    @Override
    public void deletar(Integer empresaId, Integer leilaoId) {
        Comprador comprador = buscarPorIdRetornoComprador(empresaId, leilaoId);
        compradorRepository.deleteById(comprador.getId());
    }

    @Override
    public Comprador buscarPorIdRetornoComprador(Integer empresaId, Integer leilaoId) {
        CompradorId compradorId = new CompradorId(empresaId, leilaoId);
        return compradorRepository.findById(compradorId).orElseThrow(() -> new ResourceNotFoundException(
                String.format("Não há um Comprador com o ID = %d-%d na base de dados.", empresaId, leilaoId)));
    }

    private CompradorId _gerarCompradorId(CompradorRequestDto requestDto) {
        return new CompradorId(requestDto.empresaCompradorId(), requestDto.leilaoId());
    }

    private void _verificarIntegridadeAntesCriar(CompradorId compradorId) {
        this._verificarEmpresaVendedora(compradorId);
        if (compradorRepository.existsById(compradorId)) {
            throw new DataIntegrityViolationException("Comprador já cadastrado.");
        }
    }

    private Comprador _atualizarDados(Comprador compradorSalvo, CompradorRequestDto requestDto) {
        CompradorId requestCompradorId = this._gerarCompradorId(requestDto);
        this._verificarIntegridadeAntesAtualizar(compradorSalvo, requestCompradorId);
        return _instanciarComprador(requestDto);
    }

    private void _verificarIntegridadeAntesAtualizar(Comprador compradorSalvo, CompradorId requestCompradorId) {
        this._verificarEmpresaVendedora(requestCompradorId);
        if (compradorRepository.existsById(requestCompradorId)
                && !Objects.equals(compradorSalvo.getId().getEmpresaId(), requestCompradorId.getEmpresaId())
                && !Objects.equals(compradorSalvo.getId().getLeilaoId(), requestCompradorId.getLeilaoId())
        ) {
            throw new DataIntegrityViolationException("Comprador já cadastrado.");
        }
    }

    private Comprador _instanciarComprador(CompradorRequestDto requestDto) {
        Empresa empresa = empresaBO.buscarPorIdRetornoEmpresa(requestDto.empresaCompradorId());
        Leilao leilao = leilaoBO.buscarPorIdRetornoLeilao(requestDto.leilaoId());
        return new Comprador(
                this._gerarCompradorId(requestDto),
                empresa,
                leilao
        );
    }

    private void _verificarEmpresaVendedora(CompradorId compradorId) {
        Empresa empresa = empresaBO.buscarPorIdRetornoEmpresa(compradorId.getEmpresaId());
        Leilao leilao = leilaoBO.buscarPorIdRetornoLeilao(compradorId.getLeilaoId());
        if (Objects.equals(empresa.getId(), leilao.getVendedor().getId())) {
            throw new BadRequestException("Não é permitido que uma Empresa seja Compradora e Vendedora de um mesmo Leilão");
        }
    }
}
