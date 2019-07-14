package top.felixu.grass.oauthserver.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author felixu
 * @date 2019.06.13
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDetails extends UserInfo implements org.springframework.security.core.userdetails.UserDetails, Serializable {

    private static final long serialVersionUID = 1L;

    private List<top.felixu.grass.oauthserver.entity.GrantedAuthority> grantedAuthorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getUsername() {
        return getId() + "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
