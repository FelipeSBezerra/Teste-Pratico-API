package com.felipe.entity.mapper;

import com.felipe.entity.Leilao;
import com.felipe.entity.dto.EmpresaResponseDto;
import com.felipe.entity.dto.EmpresaResponseDtoMin;
import com.felipe.entity.dto.LeilaoRequestDto;
import com.felipe.entity.dto.LeilaoResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class LeilaoMapper {

    private final EmpresaMapper empresaMapper;

    public LeilaoResponseDto toResponseDto(Leilao leilao) {
        return new LeilaoResponseDto(
                leilao.getId(),
                leilao.getCodigo(),
                leilao.getDescricao(),
                new EmpresaResponseDtoMin(leilao.getVendedor().getId(), leilao.getVendedor().getRazaoSocial()),
                leilao.getInicioPrevisto(),
                leilao.getCreatedAt(),
                leilao.getUpdatedAt()
        );
    }

    public Leilao toLeilao(LeilaoRequestDto requestDto, EmpresaResponseDto vendedor) {
        return Leilao.builder()
                .codigo(requestDto.codigo())
                .descricao(requestDto.descricao())
                .vendedor(empresaMapper.toEmpresaFromResponseDto(vendedor))
                .inicioPrevisto(requestDto.inicioPrevisto())
                .build();
    }
}
