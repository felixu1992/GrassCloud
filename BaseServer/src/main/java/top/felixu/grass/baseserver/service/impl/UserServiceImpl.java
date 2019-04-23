package top.felixu.grass.baseserver.service.impl;

import top.felixu.grass.baseserver.entity.User;
import top.felixu.grass.baseserver.mapper.UserMapper;
import top.felixu.grass.baseserver.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author felixu
 * @since 2019-04-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
