package com.bancar.services.dto.globalProcessing;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorResponse {
    @JsonProperty("Code")
    private int code;
    @JsonProperty("Message")
    private String message;
}
