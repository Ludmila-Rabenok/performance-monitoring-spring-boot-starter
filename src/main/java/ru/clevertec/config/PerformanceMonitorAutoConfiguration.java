package ru.clevertec.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.clevertec.aop.PerformanceMonitorAspect;

@Configuration
@EnableConfigurationProperties(PerformanceMonitorProperties.class)
@ConditionalOnProperty(prefix = "performance-monitoring", name = "enabled", havingValue = "true")
public class PerformanceMonitorAutoConfiguration {

    @Bean
    public PerformanceMonitorAspect performanceMonitorAspectBean(PerformanceMonitorProperties properties) {
        return new PerformanceMonitorAspect(properties);
    }
}