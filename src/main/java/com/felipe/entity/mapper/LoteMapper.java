package com.felipe.entity.mapper;

import com.felipe.entity.Leilao;
import com.felipe.entity.Lote;
import com.felipe.entity.dto.LoteRequestDto;
import com.felipe.entity.dto.LoteResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class LoteMapper {

    public LoteResponseDto toResponseDto(Lote lote) {
        return new LoteResponseDto(
                lote.getId(),
                lote.getNumeroLote(),
                lote.getDescricao(),
                lote.getQuantidade(),
                lote.getValorInicial(),
                lote.getUnidade(),
                lote.getLeilao().getId(),
                lote.getCreatedAt(),
                lote.getUpdatedAt()
        );
    }

    public Lote toLote(LoteRequestDto requestDto, Leilao leilao) {
        return Lote.builder()
                .numeroLote(requestDto.numeroLote())
                .descricao(requestDto.descricao())
                .quantidade(requestDto.quantidade())
                .valorInicial(requestDto.valorInicial())
                .unidade(requestDto.unidade())
                .leilao(leilao)
                .build();
    }
}
