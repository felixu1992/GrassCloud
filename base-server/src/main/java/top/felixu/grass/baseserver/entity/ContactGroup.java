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
public class ContactGroup extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 组所属的用户user_id
     */
    private Long userId;

    /**
     * 组名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;


}
