package com.felipe.entity.mapper;

import com.felipe.entity.Empresa;
import com.felipe.entity.Leilao;
import com.felipe.entity.dto.EmpresaResponseDtoMin;
import com.felipe.entity.dto.LeilaoRequestDto;
import com.felipe.entity.dto.LeilaoResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
@AllArgsConstructor
public class LeilaoMapper {

    public LeilaoResponseDto toResponseDto(Leilao leilao) {
        return new LeilaoResponseDto(
                leilao.getId(),
                leilao.getCodigo(),
                leilao.getDescricao(),
                new EmpresaResponseDtoMin(leilao.getVendedor().getId(), leilao.getVendedor().getRazaoSocial()),
                leilao.getInicioPrevisto(),
                leilao.getValorTotal(),
                leilao.getCreatedAt(),
                leilao.getUpdatedAt()
        );
    }


    public Leilao toLeilao(LeilaoRequestDto requestDto, Empresa vendedor) {
        return Leilao.builder()
                .codigo(requestDto.codigo())
                .descricao(requestDto.descricao())
                .vendedor(vendedor)
                .inicioPrevisto(requestDto.inicioPrevisto())
                .lotes(new ArrayList<>())
                .build();
    }
}
