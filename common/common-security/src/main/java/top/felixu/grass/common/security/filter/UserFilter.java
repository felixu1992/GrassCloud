package top.felixu.grass.common.security.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestAttributes;
import top.felixu.grass.common.core.constants.GrassConstants;
import top.felixu.grass.common.core.constants.UserConstants;
import top.felixu.grass.common.core.utils.HttpUtils;
import top.felixu.grass.common.core.utils.ValueUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author felixu
 * @date 2019.07.16
 */
@Configuration
public class UserFilter implements Filter {

    @Bean
    public FilterRegistrationBean<UserFilter> filterFilterRegistrationBean() {
        FilterRegistrationBean<UserFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(this);
        bean.setName("userFilter");
        bean.addUrlPatterns("/*");
        return bean;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpUtils.getRequestAttributes().setAttribute(UserConstants.Field.USER_ID, getCurrentUserId(),
                RequestAttributes.SCOPE_REQUEST);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * 获取当前请求用户的userId
     *
     * @return userId
     */
    private static String getCurrentUserId() {
        String userId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ValueUtils.sameAs(userId, GrassConstants.Default.STRANGER_USER_STR,
                GrassConstants.Default.STRANGER_USER_ID);
    }
}
