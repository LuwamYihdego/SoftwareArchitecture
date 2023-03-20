package service;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {

        http

//                .authorizeRequests()
//                .antMatchers("/name").permitAll()
//                .antMatchers("/salary").hasRole("MANAGER")
//                .antMatchers("/phone").hasRole("USER")
//                .anyRequest()
//                .authenticated();

                .authorizeRequests()
                .antMatchers("/product").permitAll()
                .antMatchers("/employee").hasAnyRole("EMPLOYEE,MANAGER")
                .antMatchers("/salary").hasRole("MANAGER")
                .anyRequest()
                .authenticated();
    }
}
