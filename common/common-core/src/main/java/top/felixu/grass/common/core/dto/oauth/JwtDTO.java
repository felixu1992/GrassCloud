package top.felixu.grass.common.core.dto.oauth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * JWT信息封装
 *
 * @author felixu
 * @date 2019.06.15
 */
@Data
public class JwtDTO {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("expires_in")
    private int expiresIn;
    @JsonProperty("scope")
    private String scope;
    @JsonProperty("jti")
    private String jti;
}