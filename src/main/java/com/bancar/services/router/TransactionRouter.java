package com.bancar.services.router;

import com.bancar.services.dto.DailyTransactionResponse;
import io.quarkus.vertx.web.Param;
import io.quarkus.vertx.web.Route;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Slf4j
@OpenAPIDefinition(info = @Info(title = "Transaction example API",
                version = "1.0.0"))
public class TransactionRouter {
    private final String BASE_PATH = "/transaction";
    private final String JSON_MEDIA_TYPE = "application/json";

    @Route(methods = {HttpMethod.GET},
            path = BASE_PATH + "/:accountId",
            produces = {JSON_MEDIA_TYPE})
    DailyTransactionResponse findById(RoutingContext context, @Param("accountId") String accountId,
                                      @Param("fromDate") String fromDate, @Param("toDate") String toDate) {
        log.info("{}, {}", accountId, context.queryParams());

        return null;
    }
}
