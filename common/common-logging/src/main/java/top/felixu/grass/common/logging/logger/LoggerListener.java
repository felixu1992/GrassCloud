package top.felixu.grass.common.logging.logger;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * 日志实现
 * 由AOP产生日志
 * 进入MQ队列，由日志服务消费入库
 * 异步解耦
 *
 * @author felixu
 * @date 2019.06.17
 */
@Component
@AllArgsConstructor
public class LoggerListener implements AccessLoggerListener {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void onLogger(AccessLoggerInfo info) {
        System.out.println(info.getAction());
        System.out.println(info.getIp());
        System.out.println(info.getHttpMethod());
        System.out.println(info.getMethod());
        System.out.println(info.getTarget());
        System.out.println(info.getUrl());
        System.out.println(info.getDuration());
        System.out.println(info.getResponse());
    }
}