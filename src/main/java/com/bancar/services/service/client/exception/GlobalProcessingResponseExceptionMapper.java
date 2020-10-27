package com.bancar.services.service.client.exception;

import com.bancar.services.dto.globalProcessing.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import javax.ws.rs.core.Response;

@Slf4j
public class GlobalProcessingResponseExceptionMapper implements ResponseExceptionMapper<GlobalProcessingResponseError> {
    @Override
    public GlobalProcessingResponseError toThrowable(Response response) {
        String message;
        if (response.hasEntity()) {
            ErrorResponse errorResponse = response.readEntity(ErrorResponse.class);
            message = errorResponse.getMessage();
        } else {
            message = response.getStatusInfo().getReasonPhrase();
        }
        log.error("Error: {}", message);
        return new GlobalProcessingResponseError(message);
    }
}
