package com.user_service.config.logging;

import io.jaegertracing.internal.JaegerTracer;
import io.jaegertracing.internal.samplers.ConstSampler;
import io.opentracing.Tracer;
import io.opentracing.noop.NoopTracerFactory;
import io.opentracing.util.GlobalTracer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JaegerConfig {

    @Value("${opentracing.jaeger.enabled:true}")
    private boolean jaegerEnabled;

    @Value("${opentracing.jaeger.udp-sender.host:localhost}")
    private String opentracingUdpSenderHost;

    @Value("${opentracing.jaeger.udp-sender.port:6831}")
    private Integer opentracingUdpSenderPort;

    @Bean
    public Tracer jaegerTracer() {

        if (!jaegerEnabled)
            return NoopTracerFactory.create();

        JaegerTracer tracer = new io.jaegertracing.Configuration("user-service")
                .withSampler(new io.jaegertracing.Configuration.SamplerConfiguration().withType(ConstSampler.TYPE).withParam(1))
                .withReporter(new io.jaegertracing.Configuration.ReporterConfiguration()
                        .withSender(new io.jaegertracing.Configuration.SenderConfiguration()
                                .withAgentHost(opentracingUdpSenderHost).withAgentPort(opentracingUdpSenderPort)).withLogSpans(true)).getTracer();

        GlobalTracer.registerIfAbsent(tracer);

        return tracer;
    }
}