package ru.clevertec.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "performance-monitoring")
public class PerformanceMonitorProperties {

    private boolean enabled;
    private long time;
}