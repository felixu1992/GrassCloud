package top.felixu.grass.common.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author felixu
 * @date 2019.04.23
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private long id;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 更新人
     */
    private String updateBy;
}
