package top.felixu.grass.baseserver.controller;

import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.felixu.grass.baseserver.service.UserInfoService;
import top.felixu.grass.common.core.dto.BaseResp;
import top.felixu.grass.common.core.dto.base.LoginDTO;
import top.felixu.grass.common.core.form.base.LoginForm;
import top.felixu.grass.common.core.utils.ValueUtils;
import top.felixu.grass.common.logging.annotation.AccessLogger;

/**
 * User 相关操作前端控制器
 *
 * @author felixu
 * @date 2019.07.12
 */
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserInfoController {

    private final UserInfoService userInfoService;

    @AccessLogger("用户登录")
    @PostMapping("/login")
    public BaseResp<LoginDTO> login(@Validated @RequestBody LoginForm form, BindingResult result) {
        ValueUtils.checkParams(result);
        return BaseResp.onSuc(userInfoService.login(form));
    }
}