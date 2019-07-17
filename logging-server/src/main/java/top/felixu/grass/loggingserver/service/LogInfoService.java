package top.felixu.grass.loggingserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.BeanUtils;
import top.felixu.grass.common.core.dto.log.LogInfoDTO;
import top.felixu.grass.common.core.form.logging.LogInfoForm;
import top.felixu.grass.common.core.utils.DateUtils;
import top.felixu.grass.common.core.utils.ValueUtils;
import top.felixu.grass.loggingserver.entity.LogInfo;
import top.felixu.grass.loggingserver.mapper.LogInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * log 操作实现类
 *
 * @author felixu
 * @date 2019.07.17
 */
@Service
public class LogInfoService extends ServiceImpl<LogInfoMapper, LogInfo> implements IService<LogInfo> {

    public LogInfoDTO addLogInfo(LogInfoForm form) {
        LogInfo logInfo = new LogInfo();
        BeanUtils.copyProperties(form, logInfo);
        logInfo.setParameters(form.getParameters().toString());
        logInfo.setHttpHeaders(form.getHttpHeaders().toString());
        logInfo.setResponse(form.getResponse().toString());
        logInfo.setRequestTime(DateUtils.dateToLocalDateTime(new Date(form.getRequestTime())));
        logInfo.setResponseTime(DateUtils.dateToLocalDateTime(new Date(form.getResponseTime())));
        logInfo.setError(ValueUtils.nullAs(form.getError(), new Throwable()).getLocalizedMessage());
        save(logInfo);
        return toDTO(logInfo);
    }

    private LogInfoDTO toDTO(LogInfo logInfo) {
        LogInfoDTO dto = new LogInfoDTO();
        BeanUtils.copyProperties(logInfo, dto);
        return dto;
    }
}
