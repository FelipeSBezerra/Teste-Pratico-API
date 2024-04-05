package com.felipe.service;

import com.felipe.business.CompradorBO;
import com.felipe.entity.dto.CompradorRequestDto;
import com.felipe.entity.dto.CompradorResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("comprador")
@AllArgsConstructor
public class CompradorService {

    private final CompradorBO compradorBO;

    @GetMapping("/{empresaId}-{leilaoId}")
    public ResponseEntity<CompradorResponseDto> buscarPorId(@PathVariable Integer empresaId, @PathVariable Integer leilaoId) {
        return ResponseEntity.ok(compradorBO.buscarPorId(empresaId, leilaoId));
    }

    @GetMapping
    public ResponseEntity<List<CompradorResponseDto>> buscarTodos() {
        return ResponseEntity.ok(compradorBO.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<CompradorResponseDto> criar(@Valid @RequestBody CompradorRequestDto requestDto) {
        CompradorResponseDto compradorSalvo = compradorBO.criar(requestDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{empresaId}-{leilaoId}").buildAndExpand(compradorSalvo.empresaCompradorId(), compradorSalvo.leilaoId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{empresaId}-{leilaoId}")
    public ResponseEntity<CompradorResponseDto> atualizar(@PathVariable Integer empresaId, @PathVariable Integer leilaoId, @Valid @RequestBody CompradorRequestDto requestDto) {
        return ResponseEntity.ok(compradorBO.atualizar(empresaId, leilaoId, requestDto));
    }

    @DeleteMapping("/{empresaId}-{leilaoId}")
    public ResponseEntity<Void> deletar(@PathVariable Integer empresaId, @PathVariable Integer leilaoId) {
        compradorBO.deletar(empresaId, leilaoId);
        return ResponseEntity.noContent().build();
    }
}
