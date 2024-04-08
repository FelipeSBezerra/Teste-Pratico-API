package com.felipe.entity.mapper;

import com.felipe.entity.Unidade;
import com.felipe.entity.dto.UnidadeResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class UnidadeMapper {

    public UnidadeResponseDto toResponseDto(Unidade unidade) {
        return new UnidadeResponseDto(
                unidade.getId(),
                unidade.getNome(),
                unidade.getCreatedAt(),
                unidade.getUpdatedAt()
        );
    }
}
