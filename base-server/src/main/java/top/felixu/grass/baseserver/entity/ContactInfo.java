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
public class ContactInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 所属用户的用户user_id
     */
    private Long userId;

    /**
     * 联系人名称
     */
    private String name;

    /**
     * 联系人名称首字母
     */
    private String index;

    /**
     * 联系人号码
     */
    private String mobile;

    /**
     * 联系人邮件
     */
    private String email;

    /**
     * 联系人头像地址
     */
    private String avatar;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 通讯录组表id
     */
    private Long groupId;
}
