package com.felipe.entity.mapper;

import com.felipe.entity.Comprador;
import com.felipe.entity.dto.CompradorResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class CompradorMapper {

    public CompradorResponseDto toResponseDto(Comprador comprador) {
        return new CompradorResponseDto(
                comprador.getEmpresa().getId(),
                comprador.getEmpresa().getRazaoSocial(),
                comprador.getLeilao().getId()
        );
    }
}
