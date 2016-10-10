package com.cecep.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 处理jsp请求，防止用户直接输入jsp地址访问jsp页面 处理考勤及食堂中个人查询统计
 * 
 * @author lilei
 * 
 */
public class JspParamFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 将jsp请求中参数包含personal的添加到attribute中
		HttpServletRequest request2 = (HttpServletRequest) request;
		String personal = request.getParameter("personal");
		String goSync = request.getParameter("goSync");
		if (personal != null) {
			request2.setAttribute("personal", Integer.valueOf(personal));
		}
		if (goSync != null) {
			request2.setAttribute("goSync", Integer.valueOf(goSync));
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
	}

}
