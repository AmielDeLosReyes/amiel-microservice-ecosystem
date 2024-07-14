package com.user_service.config.logging;

import io.opentracing.Span;
import io.opentracing.Tracer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TracingAspect {

    private static final Logger logger = LoggerFactory.getLogger(TracingAspect.class);

    @Autowired
    private Tracer tracer;

    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping) && execution(* com.user_service.rest.controller.*.*(..))")
    public Object traceMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String spanName = className + "." + methodName;

        Span span = tracer.buildSpan(spanName).start();
        logger.info("Tracing span '{}' started.", spanName);

        try {
            return joinPoint.proceed();
        } finally {
            span.finish();
            logger.info("Tracing span '{}' finished.", spanName);
        }
    }

    @Around("execution(* org.springframework.boot.SpringApplication.run(..)) && args(source, ..)")
    public void traceApplicationStartup(ProceedingJoinPoint joinPoint, Object source) throws Throwable {
        Span span = tracer.buildSpan("ApplicationStartup").start();
        logger.info("Tracing span '{}' started.", span.context().toTraceId());

        try {
            joinPoint.proceed();
        } finally {
            span.finish();
            logger.info("Tracing span '{}' finished.", span.context().toTraceId());
        }
    }
}
