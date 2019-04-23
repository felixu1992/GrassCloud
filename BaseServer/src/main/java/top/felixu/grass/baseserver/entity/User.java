package top.felixu.grass.baseserver.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.felixu.grass.common.entity.BaseEntity;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author felixu
 * @since 2019-04-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class User extends BaseEntity {



    /**
     * 用户名
     */
    private String userId;

    /**
     * "登录名"
     */
    private String loginName;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 密码，需加密存储
     */
    private String password;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 手机绑定与否1已经绑定2没有绑定
     */
    private Boolean mobileFlag;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 邮箱是否绑定1 绑定 2没有绑定
     */
    private Boolean emailFlag;

    /**
     * 密码最后的修改时间
     */
    private LocalDateTime pwdLastModified;

    /**
     * 登录ip
     */
    private String loginIp;

    /**
     * 登录的mac
     */
    private String loginMac;

    /**
     * 登录时间
     */
    private LocalDateTime loginTime;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 工作状态
     */
    private Boolean workStatus;

    /**
     * 0停用1启用2锁定
     */
    private Boolean status;

    /**
     * 账号短信验证的日期
     */
    private LocalDateTime smsValidateTime;

    /**
     * 用户头像
     */
    private String avatar;



    /**
     * 用户realName 首字母
     */
    private String index;

    /**
     * 性别。0表示未定义，1表示男性，2表示女性
     */
    private Boolean gender;


}
