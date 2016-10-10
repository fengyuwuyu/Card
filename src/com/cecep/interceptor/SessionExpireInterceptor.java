package com.cecep.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cecep.model.DtUser;
/**
 * 用于处理session过期的拦截器
 * @author lilei
 *
 */
public class SessionExpireInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		String url = request.getServletPath();
		if(url.endsWith("login.do")){
			return true;
		}
		DtUser user = (DtUser) request.getSession().getAttribute("currUser");
		if(user==null){
			if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){ //如果是ajax请求响应头会有，x-requested-with  
                response.setHeader("sessionstatus", "timeout");//在响应头设置session状态  
            }else{
            	response.sendRedirect(request.getContextPath()+"/login.jsp");
            }  
			return false;
		}
		
		return true;
	}

}
