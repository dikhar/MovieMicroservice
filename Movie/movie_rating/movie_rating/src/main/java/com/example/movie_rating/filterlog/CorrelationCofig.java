package com.example.movie_rating.filterlog;

import lombok.Data;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class CorrelationCofig {
    public static final String DEFAULT_HEADER_TOKEN="correlationId";
    public static final String DEFAULT_MDC="correlationId";

    private String responseHeader=DEFAULT_HEADER_TOKEN;
    private String mdcKey=DEFAULT_MDC;
    private String requestHeader=DEFAULT_HEADER_TOKEN;
    @Bean
    public FilterRegistrationBean<CorrelationIdFilter>servletRegister()
    {
        final FilterRegistrationBean<CorrelationIdFilter>registrationBean=new FilterRegistrationBean();
        final CorrelationIdFilter log4j=new CorrelationIdFilter(responseHeader,requestHeader,mdcKey);
        registrationBean.setFilter(log4j);
        registrationBean.setOrder(2);
        return registrationBean;
    }

}
