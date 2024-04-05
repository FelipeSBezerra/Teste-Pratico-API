package com.felipe.service;

import com.felipe.business.LeilaoBO;
import com.felipe.entity.dto.LeilaoRequestDto;
import com.felipe.entity.dto.LeilaoResponseDto;
import com.felipe.repository.specification.LeilaoSpecification;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("leilao")
@AllArgsConstructor
public class LeilaoService {

    private final LeilaoBO leilaoBO;

    @GetMapping("/{id}")
    public ResponseEntity<LeilaoResponseDto> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(leilaoBO.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<LeilaoResponseDto>> buscarTodos(LeilaoSpecification specification) {
        return ResponseEntity.ok(leilaoBO.buscarTodos(specification));
    }

    @PostMapping
    public ResponseEntity<LeilaoResponseDto> criar(@Valid @RequestBody LeilaoRequestDto requestDto) {
        LeilaoResponseDto leilaoSalvo = leilaoBO.criar(requestDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(leilaoSalvo.id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeilaoResponseDto> atualizar(@PathVariable Integer id, @Valid @RequestBody LeilaoRequestDto requestDto) {
        return ResponseEntity.ok(leilaoBO.atualizar(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        leilaoBO.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
