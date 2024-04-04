package com.felipe.business;

import com.felipe.business.exception.DataIntegrityViolationException;
import com.felipe.business.exception.ResourceNotFoundException;
import com.felipe.entity.Empresa;
import com.felipe.entity.dto.EmpresaRequestDto;
import com.felipe.entity.dto.EmpresaResponseDto;
import com.felipe.entity.mapper.EmpresaMapper;
import com.felipe.repository.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmpresaBOImpl implements EmpresaBO{

    private final EmpresaRepository empresaRepository;
    private final EmpresaMapper empresaMapper;
    @Override
    public EmpresaResponseDto buscarPorId(Integer id) {
        return empresaMapper.toResponseDto(this.buscarPorIdRetornoEmpresa(id));
    }

    @Override
    public List<EmpresaResponseDto> buscarTodos() {
        return empresaRepository.findAll()
                .stream().map(empresaMapper::toResponseDto).collect(Collectors.toList());
    }

    @Override
    public EmpresaResponseDto criar(EmpresaRequestDto requestDto) {
        this._validarCamposUnicos(null, requestDto);
        Empresa novaEmpresa = empresaMapper.toEmpresa(requestDto);
        novaEmpresa.setCreatedAt(Instant.now());
        novaEmpresa.setUpdatedAt(Instant.now());
        return empresaMapper.toResponseDto(empresaRepository.save(novaEmpresa));
    }

    @Override
    public EmpresaResponseDto atualizar(Integer id, EmpresaRequestDto requestDto) {
        Empresa empresaSalva= this.buscarPorIdRetornoEmpresa(id);
        this._validarCamposUnicos(id, requestDto);
        return empresaMapper.toResponseDto(
                empresaRepository.save(this._atualizarDados(empresaSalva, requestDto))
        );
    }

    @Override
    public void deletar(Integer id) {
        Empresa empresa = this.buscarPorIdRetornoEmpresa(id);
        _verificarIntegridadeAntesExclusao(empresa);
        empresaRepository.deleteById(id);
    }

    @Override
    public Empresa buscarPorIdRetornoEmpresa(Integer id) {
        return empresaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                String.format("Não há uma Empresa com o ID = %d na base de dados.", id)));
    }

    private void _validarCamposUnicos(Integer id, EmpresaRequestDto requestDto) {
        Optional<Empresa> empresaPorCnpj = empresaRepository.findByCnpj(requestDto.cnpj());
        if (empresaPorCnpj.isPresent() && !Objects.equals(empresaPorCnpj.get().getId(), id)) {
            throw new DataIntegrityViolationException("CNPJ já cadastrado!");
        }
        Optional<Empresa> empresaPorEmail = empresaRepository.findByEmail(requestDto.email());
        if (empresaPorEmail.isPresent() && !Objects.equals(empresaPorEmail.get().getId(), id)) {
            throw new DataIntegrityViolationException("E-mail já cadastrado!");
        }
    }

    private Empresa _atualizarDados(Empresa empresaSalva, EmpresaRequestDto requestDto) {
        Empresa empresaAtualizada = empresaMapper.toEmpresa(requestDto);
        empresaAtualizada.setId(empresaSalva.getId());
        empresaAtualizada.setLeiloes(empresaSalva.getLeiloes());
        empresaAtualizada.setCreatedAt(empresaSalva.getCreatedAt());
        empresaAtualizada.setUpdatedAt(Instant.now());
        return empresaAtualizada;
    }

    private void _verificarIntegridadeAntesExclusao(Empresa empresa) {
        if (!empresa.getLeiloes().isEmpty()) {
            throw new DataIntegrityViolationException("A Empresa possui Leilões e não pode ser excluída.");
        }
    }
}
