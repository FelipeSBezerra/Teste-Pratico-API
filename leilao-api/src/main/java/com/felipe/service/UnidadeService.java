package com.felipe.service;

import com.felipe.business.UnidadeBO;
import com.felipe.entity.dto.UnidadeRequestDto;
import com.felipe.entity.dto.UnidadeResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("unidade")
@AllArgsConstructor
public class UnidadeService {

    private final UnidadeBO unidadeBO;

    @GetMapping("/{id}")
    public ResponseEntity<UnidadeResponseDto> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(unidadeBO.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<UnidadeResponseDto>> buscarTodos() {
        return ResponseEntity.ok(unidadeBO.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<UnidadeResponseDto> criar(@Valid @RequestBody UnidadeRequestDto requestDto) {
        UnidadeResponseDto unidadeSalva = unidadeBO.criar(requestDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(unidadeSalva.id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadeResponseDto> atualizar(@PathVariable Integer id, @Valid @RequestBody UnidadeRequestDto requestDto) {
        return ResponseEntity.ok(unidadeBO.atualizar(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        unidadeBO.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
