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
public class PermissionInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父菜单编号
     */
    private String parentId;

    /**
     * 菜单编号
     */
    private String permissionId;

    /**
     * 权限标志
     */
    private String permission;

    /**
     * 菜单描述
     */
    private String remark;

    /**
     * 菜单状态
     */
    private Integer status;

    /**
     * 菜单类型
     */
    private Integer type;

    /**
     * 按钮路径
     */
    private String icon;

    /**
     * 菜单对应的api或者外部url
     */
    private String url;

    /**
     * 菜单的位置，排序1,1001
     */
    private String sort;

    /**
     * 打开方式
     */
    private String target;

    /**
     * 参数
     */
    private String urlparam;
}
