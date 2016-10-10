package com.cecep.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一身份认证拦截器
 * 拦截所有请求并判断其是否有ticket参数，若有则向统一身份认证系统验证ticket是否有效，否则转发到统一认证系统的登录页面
 * @author lilei
 *
 */
public class UnifiedIdentityAuthorFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String ticket = request.getParameter("ticket");
		HttpServletResponse response2 = (HttpServletResponse) response;
		if(ticket==null||"".equals(ticket)){
			//跳转到统一身份认证系统的登录页面
			response2.sendRedirect("");
		}else{
			//向统一身份认证系统验证ticket是否有效
			String ip = request.getRemoteAddr();
			
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
