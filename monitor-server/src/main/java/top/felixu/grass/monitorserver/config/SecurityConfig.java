package top.felixu.grass.monitorserver.config;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * @author felixu
 * @date 2019.07.15
 */
@EnableWebSecurity
@Configuration
public  class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Order(1)
    @Profile("dev")
    @Configuration
    public static class SecuritySecureConfig extends WebSecurityConfigurerAdapter {

        private final String adminContextPath;

        public SecuritySecureConfig(AdminServerProperties adminServerProperties) {
            this.adminContextPath = adminServerProperties.getContextPath();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
            successHandler.setTargetUrlParameter("redirectTo");

            http.authorizeRequests()
                    .antMatchers(adminContextPath + "/assets/**").permitAll()
                    .antMatchers(adminContextPath + "/login").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler)
                    .and()
                    .logout().logoutUrl(adminContextPath + "/logout").and()
                    .httpBasic().and()
                    .csrf().disable();
            // @formatter:on
        }
    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // Page with login form is served as /login.html and does a POST on /login
//        http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").permitAll();
//        // The UI does a POST on /logout on logout
//        http.logout().logoutUrl("/logout");
//        // The ui currently doesn't support csrf
//        http.csrf().disable();
//
//        // Requests for the login page and the static assets are allowed
//        http.authorizeRequests()
//                .antMatchers("/login.html", "/**/*.css", "/img/**", "/third-party/**", "/login")
//                .permitAll();
//        // ... and any other request needs to be authorized
//        http.authorizeRequests().antMatchers("/**").authenticated();
//
//        // Enable so that the clients can authenticate via HTTP basic for registering
//        http.httpBasic();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin").password("123456").roles("USER");
//    }
}