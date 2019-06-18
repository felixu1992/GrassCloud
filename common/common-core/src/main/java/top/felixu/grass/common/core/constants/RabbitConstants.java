package top.felixu.grass.common.core.constants;

/**
 * RabbitMQ相关常量池
 * 用于存储Routing Key、Exchange、Queue的定义
 *
 * @author felixu
 * @date 2019.06.18
 */
public interface RabbitConstants {

    /**
     * 队列名
     */
    interface QueueName {
        /**
         * 前缀
         */
        String PREFIX = "grass-";
        /**
         * 日志队列
         */
        String ACCESS_LOGGER = PREFIX + "access-logging-queue";

    }

    /**
     * 交换机
     */
    interface Exchange {
        /**
         * 后缀
         */
        String SUFFIX = "-exchange";
        /**
         * 日志队列交换机
         */
        String ACCESS_LOGGER = QueueName.ACCESS_LOGGER + SUFFIX;
    }

    /**
     * Routing
     */
    interface RoutingKey {
        /**
         * 日志交换机RoutingKey
         */
        String ACCESS_LOGGER = QueueName.ACCESS_LOGGER;
    }
}
