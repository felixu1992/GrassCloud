package top.felixu.grass.loggingserver.queue;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.felixu.grass.common.core.form.logging.LogInfoForm;
import top.felixu.grass.loggingserver.service.LogInfoService;

/**
 * @author felixu
 * @date 2019.06.18
 */
@Slf4j
@Component
@AllArgsConstructor
public class AccessLoggerReceiver {

    private final LogInfoService logInfoService;

    public void receiveMessage(LogInfoForm event) {
        try {
            log.info("[AccessLoggerReceiver#receiveMessage] ===> event={}", event);
            logInfoService.addLogInfo(event);
        } catch (Exception e) {
            log.error("[AccessLoggerReceiver#receiveMessage] ===> error={}", e.getLocalizedMessage());
        }
    }
}
