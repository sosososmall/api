package com.pokerstar.api.infrastructure.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter
public class TokenFilter implements Filter {
    private static Logger Log = LoggerFactory.getLogger(TokenFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Log.info("token filter start............");

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String requestUrl = request.getRequestURL().toString();
        boolean isPayRequest = requestUrl.contains("/pay/") || requestUrl.contains("/callback/") || requestUrl.contains("/order/");
        if (!isPayRequest) {
            // 非支付类请求需要验证请求token
            //todo add token check
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

}
