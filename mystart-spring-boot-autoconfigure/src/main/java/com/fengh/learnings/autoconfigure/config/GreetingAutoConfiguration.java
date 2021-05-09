package com.fengh.learnings.autoconfigure.config;

import com.fengh.learnings.service.GreetingService;
import com.fengh.learnings.service.impl.GreetingServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(value = {GreetingProperties.class})
@ConditionalOnProperty(prefix = "mystart.greeting", name = "enable", havingValue = "true", matchIfMissing = true)
//@ConditionalOnClass(value = {GreetingServiceImpl.class})
public class GreetingAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(GreetingService.class)
    public GreetingService greetingService(GreetingProperties properties) {
        System.out.println(Instant.now()+",auto config GreetingService");
        return new GreetingServiceImpl(properties.getNames());
    }
}
