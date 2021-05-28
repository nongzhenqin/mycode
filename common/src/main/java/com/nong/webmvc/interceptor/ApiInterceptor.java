package com.nong.webmvc.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: ApiInterceptor
 * @Description: API拦截器
 * @author NongZhenQin
 * @date 2018-06-22 15:41:19
 */
public class ApiInterceptor extends HandlerInterceptorAdapter {

    /**
     * This implementation always returns {@code true}.
     *
     * @param request
     * @param response
     * @param handler
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.err.println("你的请求被我拦截了，哈哈哈！");
        return true;
    }
}
