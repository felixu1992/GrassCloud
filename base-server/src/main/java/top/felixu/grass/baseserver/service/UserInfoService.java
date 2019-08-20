package top.felixu.grass.baseserver.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import top.felixu.grass.baseserver.entity.UserInfo;
import top.felixu.grass.baseserver.mapper.UserInfoMapper;
import top.felixu.grass.baseserver.properties.AuthProperties;
import top.felixu.grass.baseserver.remote.OauthServerClient;
import top.felixu.grass.common.core.dto.base.LoginDTO;
import top.felixu.grass.common.core.dto.oauth.JwtDTO;
import top.felixu.grass.common.core.exception.ErrorCode;
import top.felixu.grass.common.core.exception.GrassException;
import top.felixu.grass.common.core.form.base.AddLoginRecordForm;
import top.felixu.grass.common.core.form.base.LoginForm;
import top.felixu.grass.common.core.utils.HttpUtils;
import top.felixu.grass.common.core.utils.MD5Utils;

import java.time.LocalDateTime;

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

    private final LoginRecordService loginRecordService;

    @CachePut(value = "user", key = "'grass_' + #result.getUserId()", unless = "#result == null")
    public LoginDTO login(LoginForm form) {
        // 密码校验规则
        // 错误锁定逻辑
        // TODO 密码校验规则，可以用全局缓存来做，减少一次IO
        UserInfo user = findByLogin(form.getUsername());
        if (!MD5Utils.matches(form.getPassword(), user.getPassword())) {
            throw new GrassException(ErrorCode.PASSWORD_ERROR);
        }
        JwtDTO jwt = oauthServerClient.getToken(authProperties.getValue(),
                authProperties.getType(), user.getEmployeeNum(), form.getPassword());
        log.info("Login Success: user={}, jwt={}", user, jwt);
        if (ObjectUtils.isEmpty(jwt)
                || ObjectUtils.isEmpty(jwt.getAccessToken())) {
            throw new GrassException(ErrorCode.LOGIN_ERROR);
        }
        LoginDTO loginUser = new LoginDTO();
        loginUser.setUserId(user.getId());
        loginUser.setToken(jwt.getAccessToken());

        // 登录记录
        AddLoginRecordForm event = new AddLoginRecordForm();
        event.setLoginIp(HttpUtils.getIpAddress());
        event.setLoginName(user.getLoginName());
        event.setLoginTime(LocalDateTime.now());
        event.setUserId(user.getId());
        loginRecordService.addRecord(event);

        // 查询拥有菜单

        // 查询拥有角色

        return loginUser;
    }

    @Cacheable(value = "user", key = "'grass_' + #result.getId()", unless = "#result == null")
    public UserInfo findByLogin(String loginParam) {
        LambdaQueryWrapper<UserInfo> wrapper = new QueryWrapper<UserInfo>().lambda()
                .eq(UserInfo::getLoginName, loginParam).or()
                .eq( UserInfo::getEmployeeNum, loginParam).or()
                .eq(UserInfo::getPhone, loginParam).or()
                .eq( UserInfo::getEmail, loginParam);
        return getOne(wrapper);
    }
}
