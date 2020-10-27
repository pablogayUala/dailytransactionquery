package com.bancar.services.service;

import com.bancar.services.dto.GetTransactionsRequest;
import com.bancar.services.dto.globalProcessing.GetTransactionsResponse;
import com.bancar.services.service.client.exception.GlobalProcessingResponseError;

public interface TransactionService {
    GetTransactionsResponse findByAccountIdBetweenDate(GetTransactionsRequest getTransactionsRequest) throws GlobalProcessingResponseError;
}
