package top.felixu.grass.common.logging.config;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import top.felixu.grass.common.logging.logger.AccessLoggerListener;
import top.felixu.grass.common.logging.properties.LoggingProperties;
import top.felixu.grass.common.logging.support.AccessLoggerSupport;

/**
 * @author felixu
 * @date 2019.06.18
 */
@Configuration
public class LoggerConfig {

    @Bean
    @ConditionalOnProperty(prefix = LoggingProperties.PREFIX, name = "enable",
            matchIfMissing = true, havingValue = "true")
    public AccessLoggerSupport accessLoggerSupport() {
        return new AccessLoggerSupport();
    }

    @Bean
    @ConditionalOnProperty(prefix = LoggingProperties.PREFIX, name = "enable",
            matchIfMissing = true, havingValue = "true")
    public ListenerProcessor listenerProcessor() {
        return new ListenerProcessor();
    }

    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListenerProcessor implements BeanPostProcessor {

        private AccessLoggerSupport accessLoggerSupport;

        @Override
        public Object postProcessBeforeInitialization(@NonNull Object bean, String beanName) throws BeansException {
            return bean;
        }

        @Override
        public Object postProcessAfterInitialization(@NonNull Object bean, String beanName) throws BeansException {
            if (bean instanceof AccessLoggerListener) {
                accessLoggerSupport.addListener(((AccessLoggerListener) bean));
            }
            return bean;
        }
    }
}
