package top.felixu.grass.baseserver.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.felixu.grass.common.core.entity.BaseEntity;

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
public class PwdConfig extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 长度0-20位
     */
    private Integer length;

    /**
     * 是否包含大小字母
     */
    private Boolean isContainedUpperEn;

    /**
     * 是否包含小写字母
     */
    private Boolean isContainedLowerEn;

    /**
     * 是否包含数字
     */
    private Boolean isContainedNumber;

    /**
     * 是否包含特性字符
     */
    private Boolean isContainedSpecialChar;

    /**
     * 是否包含用户名
     */
    private Boolean isContainedUserId;

    /**
     * 强制更新的天数
     */
    private Integer forceUpdateDays;

    /**
     * 容忍密码错误次数
     */
    private Integer tolerateNum;

    /**
     * 每次登陆需短信验证
     */
    private Boolean smsValidateEverytime;

    /**
     * mac地址改变，短信验证
     */
    private Boolean smsValicateMacChange;

    /**
     * 强制短信验证天数
     */
    private Integer smsValidateForceDays;
}
