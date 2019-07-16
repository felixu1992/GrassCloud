package top.felixu.grass.baseserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.BeanUtils;
import top.felixu.grass.baseserver.entity.LoginRecord;
import top.felixu.grass.baseserver.mapper.LoginRecordMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.felixu.grass.common.core.form.base.AddLoginRecordForm;

/**
 * 登录记录
 *
 * @author felixu
 * @since 2019-07-12
 */
@Service
public class LoginRecordService extends ServiceImpl<LoginRecordMapper, LoginRecord> implements IService<LoginRecord> {

    public void addRecord(AddLoginRecordForm form) {
        LoginRecord record = new LoginRecord();
        BeanUtils.copyProperties(form, record);
        save(record);
    }
}