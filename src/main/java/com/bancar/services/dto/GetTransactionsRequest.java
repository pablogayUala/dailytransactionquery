package com.bancar.services.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@Builder
@RegisterForReflection
public class GetTransactionsRequest {
    private String accountId;
    private LocalDate fromDate;
    private LocalDate toDate;
}
