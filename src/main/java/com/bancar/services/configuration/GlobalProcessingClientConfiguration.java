package com.bancar.services.configuration;

import io.quarkus.arc.config.ConfigProperties;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;
import lombok.NoArgsConstructor;

@ConfigProperties(prefix = "global.processing.client")
@NoArgsConstructor
@Data
@RegisterForReflection
public class GlobalProcessingClientConfiguration {
    private String baseUrl;
    private Long connectTimeoutInSec = 60L;
    private Long readTimeoutInSec = 60L;
}
