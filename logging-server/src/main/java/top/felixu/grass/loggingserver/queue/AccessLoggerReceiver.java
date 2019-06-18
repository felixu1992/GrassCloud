package top.felixu.grass.loggingserver.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.felixu.grass.common.core.form.logging.LoggingForm;

/**
 * @author felixu
 * @date 2019.06.18
 */
@Slf4j
@Component
public class AccessLoggerReceiver {

    public void receiveMessage(LoggingForm event) {
        log.info("[AccessLoggerReceiver#receiveMessage] ===> event={}", event);
    }
}
