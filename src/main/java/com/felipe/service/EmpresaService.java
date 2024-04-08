package com.felipe.service;

import com.felipe.business.EmpresaBO;
import com.felipe.entity.dto.EmpresaRequestDto;
import com.felipe.entity.dto.EmpresaResponseDto;
import com.felipe.repository.specification.EmpresaSpecification;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("empresa")
@AllArgsConstructor
public class EmpresaService {

    private final EmpresaBO empresaBO;

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaResponseDto> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(empresaBO.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<EmpresaResponseDto>> buscarTodos(EmpresaSpecification specification) {
        return ResponseEntity.ok(empresaBO.buscarTodos(specification));
    }

    @PostMapping
    public ResponseEntity<EmpresaResponseDto> criar(@Valid @RequestBody EmpresaRequestDto requestDto) {
        EmpresaResponseDto empresaSalva = empresaBO.criar(requestDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(empresaSalva.id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaResponseDto> atualizar(@PathVariable Integer id, @Valid @RequestBody EmpresaRequestDto requestDto) {
        return ResponseEntity.ok(empresaBO.atualizar(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        empresaBO.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
