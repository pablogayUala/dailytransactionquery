package com.bancar.services.dto.globalProcessing;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
public class GetTransactionsResponse {
    @JsonProperty("Desde")
    private Double page; //TODO: verificar si realmente es page

    @JsonProperty("Cantidad")
    private Double numberOfElements;

    @JsonProperty("FechaDesde")
    private String fromDate;

    @JsonProperty("FechaHasta")
    private String toDate;

    @JsonProperty("Total")
    private Double totalElements;

    @JsonProperty("Resultado")
    private List<Transaction> transactions;
}
