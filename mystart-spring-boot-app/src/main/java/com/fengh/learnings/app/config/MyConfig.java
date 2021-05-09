package com.fengh.learnings.app.config;

import com.fengh.learnings.autoconfigure.config.GreetingAutoConfiguration;
import com.fengh.learnings.autoconfigure.config.GreetingProperties;
import com.fengh.learnings.service.GreetingService;
import com.fengh.learnings.service.impl.GreetingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;

@Configuration(proxyBeanMethods = false)
public class MyConfig  extends GreetingAutoConfiguration {

    @Bean
    @Override
    public GreetingService greetingService(GreetingProperties properties) {
        System.out.println(Instant.now()+",自定义 config 覆盖");
        properties.getNames().add("fengh");
        return new GreetingServiceImpl(properties.getNames());
    }
}
