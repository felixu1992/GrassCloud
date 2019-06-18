//package top.felixu.grass.common.logging.support;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.lang.NonNull;
//import top.felixu.grass.common.logging.logger.AccessLoggerListener;
//
///**
// * 日志的自动配置，通过{@link @EnableAccessLogger}开启注解功能，才会加载该类
// *
// * @author felixu
// * @date 2019.06.17
// * @see top.felixu.grass.common.logging.annotation.EnableAccessLogger
// */
//@Configuration
//public class AccessLoggerSupportAutoConfiguration {
//
//    @Bean
//    public AccessLoggerSupport aopAccessLoggerSupport() {
//        return new AccessLoggerSupport();
//    }
//
//    @Bean
//    public ListenerProcessor listenerProcessor() {
//        return new ListenerProcessor();
//    }
//
//    public static class ListenerProcessor implements BeanPostProcessor {
//
//        @Autowired
//        private AccessLoggerSupport accessLoggerSupport;
//
//        @Override
//        public Object postProcessBeforeInitialization(@NonNull Object bean, String beanName) throws BeansException {
//            return bean;
//        }
//
//        @Override
//        public Object postProcessAfterInitialization(@NonNull Object bean, String beanName) throws BeansException {
//            if (bean instanceof AccessLoggerListener) {
//                accessLoggerSupport.addListener(((AccessLoggerListener) bean));
//            }
//            return bean;
//        }
//    }
//}
