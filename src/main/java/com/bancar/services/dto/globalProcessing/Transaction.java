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
public class Transaction {
    @JsonProperty("Id")
    private Double id;

    @JsonProperty("Tipo")
    private Double type;

    @JsonProperty("Fecha")
    private String date;

    @JsonProperty("Descripcion")
    private String description;

    @JsonProperty("Importe")
    private Amount amount;

    @JsonProperty("TCC")
    private String tcc;

    @JsonProperty("MCC")
    private String mcc;

    @JsonProperty("DescripcionActividad")
    private String movementDescription;

    @JsonProperty("DescripcionPlan")
    private String planDescription;

    @JsonProperty("Observaciones")
    private String observations;
}
