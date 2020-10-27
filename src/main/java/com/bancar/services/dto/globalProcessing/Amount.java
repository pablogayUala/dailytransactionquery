package com.bancar.services.dto.globalProcessing;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
public class Amount {
    @JsonProperty("Monto")
    private Double amount;

    @JsonProperty("Moneda")
    private String currency;
}