package com.bancar.services.service.client;

import com.bancar.services.dto.globalProcessing.GetTransactionsResponse;
import com.bancar.services.service.client.exception.GlobalProcessingResponseError;
import org.jboss.resteasy.annotations.jaxrs.HeaderParam;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.UUID;

@Path("/Cuentas")
public interface GlobalProcessingTransactionsRestClient {

    @GET
    @Path("/{accountId}/Transacciones/Movimientos")
    @Produces("application/json")
    GetTransactionsResponse findTransactionsByAccountIdBetweenDates(@PathParam("accountId")   String accountId,
                                                                    @QueryParam("FechaDesde") String fromDate,
                                                                    @QueryParam("FechaHasta") String toDate,
                                                                    @HeaderParam("Authorization") String authorizationToken,
                                                                    @HeaderParam("RequestId") UUID requestId) throws GlobalProcessingResponseError;
}
