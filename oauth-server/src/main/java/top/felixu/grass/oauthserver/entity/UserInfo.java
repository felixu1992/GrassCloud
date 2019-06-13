package top.felixu.grass.oauthserver.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import top.felixu.grass.common.core.entity.BaseEntity;

import java.time.LocalDateTime;

/**
 * User Info Entity
 *
 * @author felixu
 * @date 2019.6.13
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String employeeNum;

    private String loginName;

    private String realname;

    private String password;

    private Integer type;

    private String phone;

    private Boolean phoneFlag;

    private String email;

    private Boolean emailFlag;

    private LocalDateTime pwdLastModify;

    private String loginIp;

    private String loginMac;

    private LocalDateTime loginTime;

    private String remark;

    private Boolean workStatus;

    private Boolean status;

    private LocalDateTime smsValidateTime;

    private String avatar;

    private String index;

    private Boolean gender;
}
