package com.bancar.services.service.client.exception;

import lombok.Getter;

@Getter
public class GlobalProcessingResponseError extends Exception {
    private final String message;

    public GlobalProcessingResponseError (String message) {
        super(message);
        this.message = message;
    }
}
