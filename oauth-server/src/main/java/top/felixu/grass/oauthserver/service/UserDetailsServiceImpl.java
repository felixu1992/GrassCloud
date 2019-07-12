package top.felixu.grass.oauthserver.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.felixu.grass.oauthserver.entity.GrantedAuthority;
import top.felixu.grass.oauthserver.entity.UserInfo;
import top.felixu.grass.oauthserver.mapper.UserInfoMapper;

import java.util.Collections;

/**
 * @author felixu
 * @date 2019.06.13
 */
@Service
public class UserDetailsServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String employeeNum) throws UsernameNotFoundException {
//        return baseMapper.getUserByEmployeeNum(employeeNum);
        top.felixu.grass.oauthserver.entity.UserDetails user = new top.felixu.grass.oauthserver.entity.UserDetails();
        user.setLoginName("felixu");
        user.setPassword("c9b43c7fa02b23f117ccb630c2ff628d");
//        user.setPassword("felixu");
        GrantedAuthority grantedAuthority = new GrantedAuthority();
        grantedAuthority.setName("USER");
        user.setGrantedAuthorities(Collections.singletonList(grantedAuthority));
        return user;
    }
}
