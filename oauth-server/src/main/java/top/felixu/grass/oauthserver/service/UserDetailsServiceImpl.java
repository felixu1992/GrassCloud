package top.felixu.grass.oauthserver.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.felixu.grass.oauthserver.entity.UserInfo;
import top.felixu.grass.oauthserver.mapper.UserInfoMapper;

/**
 * @author felixu
 * @date 2019.06.13
 */
@Service
public class UserDetailsServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String employeeNum) throws UsernameNotFoundException {
        return baseMapper.findUserDetails(employeeNum);
    }
}
