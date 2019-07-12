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
public class RoleGroup extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色组id
     */
    private String roleGroupId;

    /**
     * 角色组名称
     */
    private String roleGroupName;

    /**
     * 角色编号
     */
    private String roleId;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 1启用0停用2锁定
     */
    private Boolean status;
}
