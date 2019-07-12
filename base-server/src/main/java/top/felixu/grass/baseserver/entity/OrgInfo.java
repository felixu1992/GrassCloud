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
public class OrgInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 组织名称
     */
    private String name;

    /**
     * 父id
     */
    private String parentCode;

    /**
     * 菜单编号 (父id+自己的设置id)
     */
    private String orgCode;

    /**
     * 组织状态1表示正常使用，0表示停用
     */
    private Boolean status;

    /**
     * 预留字段（排序使用）
     */
    private String sort;

    /**
     * level 10 总公司 11中心 12部门 13室 20 分公司 21 分公司部门
     */
    private String level;

    /**
     * 负责人id（可能后期需要放到中间表）
     */
    private String principal;

    /**
     * 电话
     */
    private String telphone;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 备注
     */
    private String remarks;
}
