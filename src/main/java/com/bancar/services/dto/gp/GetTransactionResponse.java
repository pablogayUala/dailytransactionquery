package com.bancar.services.dto.gp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetTransactionResponse {
    @JsonProperty("Desde")
    private Double desde;

    @JsonProperty("Cantidad")
    private Double cantidad;

    @JsonProperty("FechaDesde")
    private String fechaDesde;

    @JsonProperty("FechaHasta")
    private String fechaHasta;

    @JsonProperty("Total")
    private Double total;

    @JsonProperty("Resultado")
    private List<Transaction> resultado;
}
