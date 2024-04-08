package com.felipe.service;

import com.felipe.business.LoteBO;
import com.felipe.entity.dto.LoteRequestDto;
import com.felipe.entity.dto.LoteResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("lote")
@AllArgsConstructor
public class LoteService {

    private final LoteBO loteBO;

    @GetMapping("/{id}")
    public ResponseEntity<LoteResponseDto> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(loteBO.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<LoteResponseDto>> buscarTodos() {
        return ResponseEntity.ok(loteBO.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<LoteResponseDto> criar(@Valid @RequestBody LoteRequestDto requestDto) {
        LoteResponseDto loteSalvo = loteBO.criar(requestDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(loteSalvo.id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoteResponseDto> atualizar(@PathVariable Integer id, @Valid @RequestBody LoteRequestDto requestDto) {
        return ResponseEntity.ok(loteBO.atualizar(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        loteBO.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
