package com.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    public List loginEssential
            = Arrays.asList("/likes/**");

    public List loginInessential
            = Arrays.asList("/members/sign-up", "members/login");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String loginId = (String)request.getSession().getAttribute("loginId");

        if (loginId != null) {return true;}

        else {
            String destUri = request.getRequestURI();
            String destQuery = request.getQueryString();
            String dest = (destQuery == null) ? destUri : destUri+"?"+destQuery;
            request.getSession().setAttribute("dest", dest);

            response.sendRedirect("/members/login");
            return false;
        }
    }
}