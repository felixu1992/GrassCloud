package top.felixu.grass.oauthserver.entity;

import lombok.Setter;

/**
 * @author felixu
 * @date 2019.06.13
 */
@Setter
public class GrantedAuthority implements org.springframework.security.core.GrantedAuthority {

    private String name;

    @Override
    public String getAuthority() {
        return this.name;
    }
}
