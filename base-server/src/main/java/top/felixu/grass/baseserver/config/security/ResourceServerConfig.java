//package top.felixu.grass.baseserver.config.security;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import top.felixu.grass.common.core.constant.GrassConstant;
//
///**
// * @author felixu
// * @date 2019.06.15
// */
//@Slf4j
//@Configuration
//@AllArgsConstructor
//@EnableResourceServer
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//
//    private final TokenStore tokenStore;
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .regexMatchers(".*swagger.*", ".*v2.*"," .*webjars.*", "/user/login.*", "/validate.*",
//                        "/user/reset-password.*")
//                .permitAll()
//                //.antMatchers("/**").authenticated();
//                .antMatchers("/**").permitAll();
//    }
//
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        log.info("Configuring ResourceServerSecurityConfigurer");
//        resources.resourceId(GrassConstant.Server.BASE).tokenStore(tokenStore);
//    }
//}
