package top.felixu.grass.loggingserver.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.felixu.grass.common.core.constants.RabbitConstants;
import top.felixu.grass.loggingserver.queue.AccessLoggerReceiver;

/**
 * RabbitMQ配置
 * 所有的队列、交换机、绑定关系等均在这里配置
 *
 * @author felixu
 * @date 2019.06.18
 */
@EnableRabbit
@Configuration
public class AmqpConfig {
    
    /*--------------------- 访问日志 ------------------------*/

    @Bean
    public Queue accessLoggerQueue() {
        return new Queue(RabbitConstants.QueueName.ACCESS_LOGGER, false);
    }

    @Bean
    public TopicExchange accessLoggerExchange() {
        return new TopicExchange(RabbitConstants.Exchange.ACCESS_LOGGER);
    }

    @Bean
    public Binding accessLoggerBinding(Queue accessLoggerQueue, TopicExchange accessLoggerExchange) {
        return BindingBuilder.bind(accessLoggerQueue).to(accessLoggerExchange)
                .with(RabbitConstants.RoutingKey.ACCESS_LOGGER);
    }

    @Bean
    public SimpleMessageListenerContainer accessLoggerContainer(ConnectionFactory connectionFactory, 
                                                                 MessageListenerAdapter accessLoggerListenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(RabbitConstants.QueueName.ACCESS_LOGGER);
        container.setMaxConcurrentConsumers(4);
        container.setConcurrentConsumers(4);
        container.setMessageListener(accessLoggerListenerAdapter);
        return container;
    }

    @Bean
    public MessageListenerAdapter accessLoggerListenerAdapter(AccessLoggerReceiver accessLoggerReceiver) {
        return new MessageListenerAdapter(accessLoggerReceiver, "receiveMessage");
    }
}
