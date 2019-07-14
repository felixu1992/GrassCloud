package top.felixu.grass.common.core.dto.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author felixu
 * @date 2019.07.12
 */
@Data
public class LoginDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long userId;

    private String token;
}
