package com.bancar.services.router;

import com.bancar.services.dto.GetTransactionsRequest;
import com.bancar.services.dto.globalProcessing.GetTransactionsResponse;
import com.bancar.services.service.TransactionService;
import com.bancar.services.service.client.exception.GlobalProcessingResponseError;
import io.quarkus.vertx.web.Param;
import io.quarkus.vertx.web.Route;
import io.vertx.ext.web.RoutingContext;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.Optional;

import static com.bancar.services.utils.DateUtils.DATE_TIME_FORMATTER;
import static io.vertx.core.http.HttpMethod.GET;

@ApplicationScoped
@OpenAPIDefinition(info = @Info(title = "Transaction example API",
                version = "1.0.0"))
public class TransactionRouter {
    private final String BASE_PATH = "/transaction";
    private final String JSON_MEDIA_TYPE = "application/json";
    private final TransactionService transactionService;

    public TransactionRouter(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Route(methods = GET, path = BASE_PATH + "/:accountId", produces = JSON_MEDIA_TYPE)
    GetTransactionsResponse findById(RoutingContext context,
                                     @Param("accountId") String accountId,
                                     @Param("FechaDesde") Optional<String> fromDate,
                                     @Param("FechaHasta") Optional<String> toDate) throws GlobalProcessingResponseError {
        LocalDate from = fromDate.map(stringDate -> LocalDate.parse(stringDate, DATE_TIME_FORMATTER)).orElse(LocalDate.now());
        LocalDate to = toDate.map(stringDate -> LocalDate.parse(stringDate, DATE_TIME_FORMATTER)).orElse(LocalDate.now().plusDays(1));
        GetTransactionsRequest getTransactionsRequest = GetTransactionsRequest.builder()
                .accountId(accountId)
                .fromDate(from)
                .toDate(to)
                .build();

        return this.transactionService.findByAccountIdBetweenDate(getTransactionsRequest);
    }
}
