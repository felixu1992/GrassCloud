package top.felixu.grass.baseserver.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.felixu.grass.baseserver.entity.UserInfo;
import top.felixu.grass.baseserver.mapper.UserInfoMapper;
import top.felixu.grass.baseserver.properties.AuthProperties;
import top.felixu.grass.baseserver.remote.OauthServerClient;
import top.felixu.grass.common.core.dto.base.LoginDTO;
import top.felixu.grass.common.core.dto.oauth.JwtDTO;
import top.felixu.grass.common.core.form.base.LoginForm;

/**
 * User 业务操作实现类
 *
 * @author felixu
 * @date 2019.07.12
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserInfoService extends ServiceImpl<UserInfoMapper, UserInfo> implements IService<UserInfo> {

    private final OauthServerClient oauthServerClient;

    private final AuthProperties authProperties;

    public LoginDTO login(LoginForm form) {
        /**
         * 1. 密码规则校验
         * 2. 错误锁定逻辑
         * 3. 认证授权
         * 4. 登录记录
         */
        // TODO 密码校验规则，可以用全局缓存来做，减少一次IO
        UserInfo user = findByLogin(form.getUsername());
        JwtDTO jwt = oauthServerClient.getToken(authProperties.getValue(),
                authProperties.getType(), user.getLoginName(), form.getPassword());
        log.info("Login Success: user={}, jwt={}", user, jwt);
        return null;
    }

    public UserInfo findByLogin(String loginParam) {
        LambdaQueryWrapper<UserInfo> wrapper = new QueryWrapper<UserInfo>().lambda()
                .eq(UserInfo::getLoginName, loginParam).or()
                .eq( UserInfo::getEmployeeNum, loginParam).or()
                .eq(UserInfo::getPhone, loginParam).or()
                .eq( UserInfo::getEmail, loginParam);
        return getOne(wrapper);
    }
}
