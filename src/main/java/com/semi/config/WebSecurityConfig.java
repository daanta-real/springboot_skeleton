package com.semi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {

/*
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(false);
    }

    //Lucy Xss filter 적용
    @Bean
    public FilterRegistrationBean xssFilterBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new XssEscapeServletFilter());
        registrationBean.setOrder(Ordered.LOWEST_PRECEDENC);
        registrationBean.addUrlPatterns("*.do", "*.jsp");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<XssEscapeServletFilter> xssEscapeServletFilterRegistrationBean() {
        FilterRegistrationBean<XssEscapeServletFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new XssEscapeServletFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("xssEscapeServletFilter");
        return registrationBean;
    }
*/

}
