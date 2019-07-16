package top.felixu.grass.common.core.form.base;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author felixu
 * @date 2019.07.16
 */
@Data
public class AddLoginRecordForm implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 登录时间
     */
    private LocalDateTime loginTime;

    /**
     * 登录ip
     */
    private String loginIp;

    /**
     * 登录mac
     */
    private String loginMac;
}
