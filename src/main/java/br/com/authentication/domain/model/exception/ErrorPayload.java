package br.com.authentication.domain.model.exception;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorPayload {
    private Integer statusCode;
    private String message;
    private String error;
}
