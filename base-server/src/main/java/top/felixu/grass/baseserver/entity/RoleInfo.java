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
public class RoleInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色编号
     */
    private String role;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 1普通用户2管理员角色3任务分配
     */
    private Boolean type;

    /**
     * 1 所有数据2 所在公司及以下数据3 所在公司数据4 所在部门及以下数据5 所在部门数据8 仅本人数据9 按明细设置
     */
    private Boolean dataScope;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态0 停用1 启用2 锁定
     */
    private Boolean status;
}
