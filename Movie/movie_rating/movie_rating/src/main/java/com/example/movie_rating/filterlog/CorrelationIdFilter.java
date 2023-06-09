package com.example.movie_rating.filterlog;

import com.example.movie_rating.filterlog.CorrelationCofig;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
@Data
@EqualsAndHashCode(callSuper = false)
public class CorrelationIdFilter extends OncePerRequestFilter {

    private final String responseHeader;
    private final String mdcKey;
    private final String requestHeader;
    public CorrelationIdFilter() {
         responseHeader= CorrelationCofig.DEFAULT_HEADER_TOKEN;
         mdcKey=CorrelationCofig.DEFAULT_MDC;
         requestHeader=CorrelationCofig.DEFAULT_HEADER_TOKEN;
    }

    public CorrelationIdFilter(String responseHeader, String mdcKey, String requestHeader) {
        this.responseHeader = responseHeader;
        this.mdcKey = mdcKey;
        this.requestHeader = requestHeader;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, ServletException, IOException {
        try
        {
            final  String token=extractToken(request);
            MDC.put(mdcKey,token);
            filterChain.doFilter(request,response);
        } finally {
            MDC.remove(mdcKey);
        }
    }
    private String extractToken(HttpServletRequest request)
    {
        final String token;
        if(!StringUtils.isAllEmpty(requestHeader)&&(!StringUtils.isAllEmpty(request.getHeader
                (requestHeader)))) {
            token=request.getHeader(requestHeader);
        }
        else {
            token = UUID.randomUUID().toString().toUpperCase().replace("-", "");
        }
        return token;
    }
}