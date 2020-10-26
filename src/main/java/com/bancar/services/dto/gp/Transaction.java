package com.bancar.services.dto.gp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @JsonProperty("Id")
    private Double id;

    @JsonProperty("Tipo")
    private Double tipo;

    @JsonProperty("Fecha")
    private String fecha;

    @JsonProperty("Descripcion")
    private String descripcion;

    @JsonProperty("Importe")
    private Amount importe;

    @JsonProperty("TCC")
    private String tcc;

    @JsonProperty("MCC")
    private String mcc;

    @JsonProperty("DescripcionActividad")
    private String descripcionActividad;

    @JsonProperty("DescripcionPlan")
    private String descripcionPlan;

    @JsonProperty("Observaciones")
    private String observaciones;
}
