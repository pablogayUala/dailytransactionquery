package com.bancar.services.dto.gp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Amount {
    @JsonProperty("Monto")
    private Double monto;

    @JsonProperty("Moneda")
    private String moneda;
}