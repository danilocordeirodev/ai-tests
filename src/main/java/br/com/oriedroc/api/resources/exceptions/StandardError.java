package br.com.oriedroc.api.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class StandardError {
    private LocalDateTime timestamp;
    private Integer statusCode;
    private String error;
    private String path;
}
