package top.felixu.common.datasource.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Druid监控配置
 * 查看监控路径 http://localhost:${port}/druid/datasource.html
 *
 * @author felixu
 * @date 2019.06.12
 */
@Configuration
public class DruidConfig {

    /**
     * 注册DruidServlet
     * @return Registration
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> druidServletRegistrationBean() {
        ServletRegistrationBean<StatViewServlet> registration = new ServletRegistrationBean<>();
        registration.setServlet(new StatViewServlet());
        registration.addUrlMappings("/druid/*");
        return registration;
    }

    /**
     * 注册DruidFilter拦截
     *
     * @return Filter
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> druidFilterRegistrationBean() {
        FilterRegistrationBean<WebStatFilter> filterRegistration = new FilterRegistrationBean<>();
        filterRegistration.setFilter(new WebStatFilter());
        //设置忽略请求
        Map<String, String> ignore = new HashMap<String, String>(16){{
            put("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        }};
        filterRegistration.setInitParameters(ignore);
        filterRegistration.addUrlPatterns("/*");
        return filterRegistration;
    }
}
