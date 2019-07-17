package top.felixu.grass.common.logging.logger;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import top.felixu.grass.common.core.constants.RabbitConstants;
import top.felixu.grass.common.core.form.logging.LogInfoForm;
import top.felixu.grass.common.core.utils.UserUtils;

import java.util.UUID;

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
@RequiredArgsConstructor
public class LoggerListener implements AccessLoggerListener {

    private final RabbitTemplate rabbitTemplate;

    @Value("${spring.application.name}")
    private String serverName;

    @Override
    public void onLogger(AccessLoggerInfo info) {
        LogInfoForm event = new LogInfoForm();
        BeanUtils.copyProperties(info, event);
        event.setServerName(serverName);
        event.setMethod(info.getMethod().getName());
        event.setTarget(info.getTarget().getName());
        event.setCreateBy(UserUtils.getCurrentUserId());
        event.setUpdateBy(UserUtils.getCurrentUserId());
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(RabbitConstants.Exchange.ACCESS_LOGGER, RabbitConstants.RoutingKey.ACCESS_LOGGER, event, correlationId);
    }
}