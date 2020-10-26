package com.bancar.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DailyTransactionRequest {
    private long account;
    private LocalDate fromDate;
    private LocalDate toDate;
}
