package top.felixu.grass.baseserver.service.impl;

import top.felixu.grass.baseserver.entity.LoginRecord;
import top.felixu.grass.baseserver.mapper.LoginRecordMapper;
import top.felixu.grass.baseserver.service.ILoginRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author felixu
 * @since 2019-07-12
 */
@Service
public class LoginRecordServiceImpl extends ServiceImpl<LoginRecordMapper, LoginRecord> implements ILoginRecordService {

}
