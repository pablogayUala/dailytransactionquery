package com.bancar.services.dto;

import java.time.LocalDate;

public class DailyTransactionRequest {
    private long account;
    private LocalDate fromDate;
    private LocalDate toDate;
}
