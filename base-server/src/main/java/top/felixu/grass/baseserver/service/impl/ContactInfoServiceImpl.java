package top.felixu.grass.baseserver.service.impl;

import top.felixu.grass.baseserver.entity.ContactInfo;
import top.felixu.grass.baseserver.mapper.ContactInfoMapper;
import top.felixu.grass.baseserver.service.IContactInfoService;
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
public class ContactInfoServiceImpl extends ServiceImpl<ContactInfoMapper, ContactInfo> implements IContactInfoService {

}
