package com.felipe.service.exception.mensagens;

import com.felipe.service.exception.mensagens.field.FieldMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class MensagemDeErroValidacao extends MensagemDeErroPadrao {

    private final List<FieldMessage> camposDeErro = new ArrayList<>();

    @Builder(builderMethodName = "MensagemDeErroValidacaoBuilder")
    public MensagemDeErroValidacao(Instant timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);
    }

    public void addErro(FieldMessage fieldMessage) {
        camposDeErro.add(fieldMessage);
    }
}
