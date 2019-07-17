package top.felixu.grass.loggingserver.service.impl;

import top.felixu.grass.loggingserver.entity.LogInfo;
import top.felixu.grass.loggingserver.mapper.LogInfoMapper;
import top.felixu.grass.loggingserver.service.ILogInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author felixu
 * @since 2019-07-17
 */
@Service
public class LogInfoServiceImpl extends ServiceImpl<LogInfoMapper, LogInfo> implements ILogInfoService {

}
