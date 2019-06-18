package top.felixu.grass.common.logging.logger;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.felixu.grass.common.core.form.logging.LoggingForm;

import java.io.Serializable;

/**
 * 日志实体
 *
 * @author felixu
 * @date 2019.06.17
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AccessLoggerInfo extends LoggingForm implements Serializable {

    private static final long serialVersionUID = 1L;

}
