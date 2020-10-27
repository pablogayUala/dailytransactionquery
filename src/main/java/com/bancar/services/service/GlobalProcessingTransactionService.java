package com.bancar.services.service;

import com.bancar.services.configuration.GlobalProcessingClientConfiguration;
import com.bancar.services.dto.GetTransactionsRequest;
import com.bancar.services.dto.globalProcessing.GetTransactionsResponse;
import com.bancar.services.service.client.GlobalProcessingTransactionsRestClient;
import com.bancar.services.service.client.exception.GlobalProcessingResponseError;
import com.bancar.services.service.client.exception.GlobalProcessingResponseExceptionMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.inject.Singleton;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.URI;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.bancar.services.utils.DateUtils.DATE_TIME_FORMATTER;

@Singleton
@Slf4j
public class GlobalProcessingTransactionService implements TransactionService {
    private final GlobalProcessingTransactionsRestClient globalProcessingTransactionsRestClient;
    private final String hardcodedToken = "bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6ImF1bkM2QV9MbHFVZGNYV3Z6UzVGOURQUEFTSSIsImtpZCI6ImF1bkM2QV9MbHFVZGNYV3Z6UzVGOURQUEFTSSJ9.eyJpc3MiOiJodHRwczovLzM0LjIyOC4yNTMuNDQ6NDQzMDEvR1AuSURTIiwiYXVkIjoiaHR0cHM6Ly8zNC4yMjguMjUzLjQ0OjQ0MzAxL0dQLklEUy9yZXNvdXJjZXMiLCJleHAiOjE2MDM4MzQ1NjEsIm5iZiI6MTYwMzgzMDk2MSwiY2xpZW50X2lkIjoiYmFuY2FyIiwiY2xpZW50X01hcmNhIjoiMSIsImNsaWVudF9Vc3VhQ29kaSI6IkRCTyIsImNsaWVudF9FbnRpZGFkIjoiNjAyIiwic2NvcGUiOiJQcmVwYWdhQXBpIn0.iS2RnohzQFdpBtWuEJlFifTye-XK8gzSCS9Q7yYKqvfh8SP4Z1pf4QYp_WKr9bQIJpbdcR09m3Ri9EyZqZe6SLHNKcUH879NBvRO3dLxUcYZfkcYeAHlBwXwF7ntdbK0ixfalEkEZ_1s8Zqs4oUzJhlZ_svKcNKnkpgThYL8Y8_wkzpFvwmkvQEusLitq-yd9Bev0TJ8bpIi1R13u2xMuVvh-ALx83v0WUPuecWITO1HcgX92TW5USQQWJWQOdGF-p-zQcrBGdZnE7eprqhct1swlsGG4vU3nqtZqGjH4OwU1X0LgtzmLMg70znueHMK-veSD_oyddECZp-8lrvs8yQBfTyytrxl8f5P7RZD1HxH9vSkYLJnFbCNsipusc2bvJjIw4vZKKU5kxRTfKba0pyEBe-JgyXtj_sf5o1Fl5odEbfMO_s_xToLaHPnyB9WCR7V6-xoi5TSW6VX347rE7fVWFoTbY1GCxHkA9-SO1nhlwLnA9q2iit2KMdLAs30RN0RxFESq8xxbbN5pVHzjOg0xmC3Jptz0a9Jp6nfDz_zdh_B_cMEeQZiKlMAztdheAuFm8ppjlFPYCE6_D_CTroshPeKgQPPeNUF3Jv-GX-_vujerVPQYlPqT45kYYCo7LfDcE3ShxAubQlS4vIviDUKw7CCyobVczAOjwjzJGI";

    @SneakyThrows
    public GlobalProcessingTransactionService(GlobalProcessingClientConfiguration globalProcessingClientConfiguration) {
        log.info("Rest URI: {}", globalProcessingClientConfiguration.getBaseUrl());
        globalProcessingTransactionsRestClient = RestClientBuilder
                .newBuilder()
                .hostnameVerifier((hostname, session) -> true)
                .baseUri(URI.create(globalProcessingClientConfiguration.getBaseUrl()))
                .sslContext(trustAllCerts())
                .connectTimeout(globalProcessingClientConfiguration.getConnectTimeoutInSec(), TimeUnit.SECONDS)
                .readTimeout(globalProcessingClientConfiguration.getReadTimeoutInSec(), TimeUnit.SECONDS)
                .register(new GlobalProcessingResponseExceptionMapper())
                .build(GlobalProcessingTransactionsRestClient.class);
    }


    @Override
    public GetTransactionsResponse findByAccountIdBetweenDate(GetTransactionsRequest request) throws GlobalProcessingResponseError {
        return this.globalProcessingTransactionsRestClient.findTransactionsByAccountIdBetweenDates(
                request.getAccountId(), request.getFromDate().format(DATE_TIME_FORMATTER),
                request.getToDate().format(DATE_TIME_FORMATTER), hardcodedToken,
                UUID.randomUUID()
        );
    }

    @SneakyThrows
    private SSLContext trustAllCerts() {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        TrustManager[] trustAllCerts = new TrustManager[]{ new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }
            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }};
        sslContext.init(null, trustAllCerts, new SecureRandom());
        return sslContext;
    }
}
