package com.example.demo.security;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler{
	@Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // Thêm thông báo lỗi vào session
        request.getSession().setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
        // Chuyển hướng về trang đăng nhập với thông báo lỗi
        response.sendRedirect("/login?error=true");
    }

	
}
