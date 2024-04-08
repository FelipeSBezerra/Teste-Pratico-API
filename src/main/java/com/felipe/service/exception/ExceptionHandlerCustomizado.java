package com.felipe.service.exception;

import com.felipe.business.exception.BadRequestException;
import com.felipe.business.exception.DataIntegrityViolationException;
import com.felipe.business.exception.ResourceNotFoundException;
import com.felipe.service.exception.mensagens.MensagemDeErroPadrao;
import com.felipe.service.exception.mensagens.MensagemDeErroValidacao;
import com.felipe.service.exception.mensagens.field.FieldMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ExceptionHandlerCustomizado {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<MensagemDeErroPadrao> badRequestException(BadRequestException exception, HttpServletRequest httpServletRequest) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        MensagemDeErroPadrao mensagemDeErro = MensagemDeErroPadrao.builder()
                .timestamp(Instant.now())
                .status(status.value())
                .error("Bad Request")
                .message(exception.getMessage())
                .path(httpServletRequest.getRequestURI())
                .build();
        return ResponseEntity.status(status).body(mensagemDeErro);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<MensagemDeErroPadrao> resourceNotFoundException(ResourceNotFoundException exception, HttpServletRequest httpServletRequest) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        MensagemDeErroPadrao mensagemDeErro = MensagemDeErroPadrao.builder()
                .timestamp(Instant.now())
                .status(status.value())
                .error("Resource Not Found")
                .message(exception.getMessage())
                .path(httpServletRequest.getRequestURI())
                .build();
        return ResponseEntity.status(status).body(mensagemDeErro);

    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<MensagemDeErroPadrao> dataIntegrityViolationException(DataIntegrityViolationException exception, HttpServletRequest httpServletRequest) {
        HttpStatus status = HttpStatus.CONFLICT;
        MensagemDeErroPadrao mensagemDeErro = MensagemDeErroPadrao.builder()
                .timestamp(Instant.now())
                .status(status.value())
                .error("Data Integrity Violation")
                .message(exception.getMessage())
                .path(httpServletRequest.getRequestURI())
                .build();
        return ResponseEntity.status(status).body(mensagemDeErro);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MensagemDeErroPadrao> methodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest httpServletRequest) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        MensagemDeErroValidacao mensagemDeErro = MensagemDeErroValidacao.MensagemDeErroValidacaoBuilder()
                .timestamp(Instant.now())
                .status(status.value())
                .error("Method Argument Not Valid")
                .message("Erro na validacao dos campos")
                .path(httpServletRequest.getRequestURI())
                .build();

        exception.getBindingResult().getAllErrors().forEach((erro) -> {
            if (erro instanceof FieldError fieldError) {
                mensagemDeErro.addErro(new FieldMessage(fieldError.getField(), erro.getDefaultMessage()));
            }
        });
        return ResponseEntity.status(status).body(mensagemDeErro);
    }

    /**
     * Trata uma exceção HttpMessageNotReadableException, retornando uma mensagem de erro
     * padronizada para quando dados inválidos são enviados no corpo da requisição.
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<MensagemDeErroPadrao> httpMessageNotReadableException(HttpMessageNotReadableException exception, HttpServletRequest httpServletRequest) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        MensagemDeErroPadrao mensagemDeErro = MensagemDeErroPadrao.builder()
                .timestamp(Instant.now())
                .status(status.value())
                .error("Http Message Not Readable")
                .message("Dados invalidos enviados. Verifique os dados enviados quanto a incompatibilidade de tipo")
                .path(httpServletRequest.getRequestURI())
                .build();
        return ResponseEntity.status(status).body(mensagemDeErro);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<MensagemDeErroPadrao> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception, HttpServletRequest httpServletRequest) {
        HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;
        MensagemDeErroPadrao mensagemDeErro = MensagemDeErroPadrao.builder()
                .timestamp(Instant.now())
                .status(status.value())
                .error("Http Request Method Not Supported")
                .message(exception.getMessage())
                .path(httpServletRequest.getRequestURI())
                .build();
        return ResponseEntity.status(status).body(mensagemDeErro);
    }

    /**
     * Trata qualquer outro tipo de exceção não listada nessa classe
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MensagemDeErroPadrao> Exception(Exception exception, HttpServletRequest httpServletRequest) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        MensagemDeErroPadrao mensagemDeErro = MensagemDeErroPadrao.builder()
                .timestamp(Instant.now())
                .status(status.value())
                .error("Generic Exception")
                .message(exception.getMessage())
                .path(httpServletRequest.getRequestURI())
                .build();
        return ResponseEntity.status(status).body(mensagemDeErro);
    }
}
