package ru.clevertec.aop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import ru.clevertec.config.PerformanceMonitorProperties;

@Aspect
@RequiredArgsConstructor
@Slf4j
public class PerformanceMonitorAspect {
    public static final String METHOD_EXECUTED_IN_MS = "Method {} executed in {} ms.";

    private final PerformanceMonitorProperties properties;

    @Pointcut("@annotation(ru.clevertec.MonitorPerformance)")
    private void isAllMethodsWithAnnotationMonitorPerformance() {
    }

    @Around("isAllMethodsWithAnnotationMonitorPerformance()")
    public Object afterReturningMethodsWithAnnotationMonitoringPerformanceLoggingExecutionTimeAdvice
            (ProceedingJoinPoint point) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = point.proceed();
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        if (timeElapsed > properties.getTime()) {
            log.info(METHOD_EXECUTED_IN_MS, point.getSignature().getName(), timeElapsed);
        }
        return result;
    }
}