package top.felixu.grass.baseserver.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.felixu.grass.common.core.entity.BaseEntity;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author felixu
 * @since 2019-07-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UserInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 工号
     */
    private String employeeNum;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户类型
     */
    private Integer type;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 手机号是否绑定，1绑定，2没有绑定
     */
    private Boolean phoneFlag;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 邮箱是否绑定，1绑定，2没有绑定
     */
    private Boolean emailFlag;

    /**
     * 上次修改密码的时间
     */
    private LocalDateTime pwdLastModify;

    /**
     * 登录ip
     */
    private String loginIp;

    /**
     * 登录mac地址
     */
    private String loginMac;

    /**
     * 登录时间
     */
    private LocalDateTime loginTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 用户工作状态
     */
    private Boolean workStatus;

    /**
     * 账号状态，0停用1启用2锁定
     */
    private Boolean status;

    /**
     * 短信验证时间
     */
    private LocalDateTime smsValidateTime;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * realname首字母
     */
    private String prefix;

    /**
     * 性别
     */
    private Boolean gender;
}
