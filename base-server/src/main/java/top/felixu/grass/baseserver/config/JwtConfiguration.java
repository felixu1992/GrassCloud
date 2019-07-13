//package top.felixu.grass.baseserver.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
//import org.springframework.util.FileCopyUtils;
//
//import java.io.IOException;
//
///**
// * JWT配置类
// *
// * @author felixu
// * @date 2019.06.13
// */
//@Slf4j
//@Configuration
//public class JwtConfiguration {
//
//    @Bean
//    protected JwtAccessTokenConverter jwtTokenEnhancer() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        Resource resource = new ClassPathResource("grass-cloud.cert");
//        String secret;
//        try {
//            secret = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        converter.setVerifierKey(secret);
//        return converter;
//    }
//
//    @Bean
//    @Qualifier("tokenStore")
//    public TokenStore tokenStore(JwtAccessTokenConverter jwtTokenEnhancer) {
//        log.info("Created JwtTokenStore");
//        return new JwtTokenStore(jwtTokenEnhancer);
//    }
//}
