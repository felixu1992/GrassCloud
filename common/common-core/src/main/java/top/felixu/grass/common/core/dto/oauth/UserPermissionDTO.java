package top.felixu.grass.common.core.dto.oauth;

import lombok.Data;

import java.io.Serializable;

/**
 * @author felixu
 * @date 2019.06.13
 */
@Data
public class UserPermissionDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String permission;
}
