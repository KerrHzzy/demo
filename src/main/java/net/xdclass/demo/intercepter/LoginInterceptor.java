package net.xdclass.demo.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author hdz
 */
public class LoginInterceptor implements HandlerInterceptor{

	/**
	 * 进入controller方法之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request
							, HttpServletResponse response
							, Object handler) throws Exception {

		System.out.println("LoginInterceptor------->preHandle------->进入controller方法之前");

//		String token = request.getParameter("access_token");
//		response.getWriter().print("fail");
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	/**
	 * 调用完controller之后，视图渲染之前
	 */
	@Override
	public void postHandle(HttpServletRequest request
							, HttpServletResponse response
							, Object handler
							, ModelAndView modelAndView) throws Exception {
		
		System.out.println("LoginInterceptor------->postHandle------>调用完controller之后，视图渲染之前");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * 整个完成之后，通常用于资源清理
	 */
	@Override
	public void afterCompletion(HttpServletRequest request
								, HttpServletResponse response
								, Object handler
								, Exception ex) throws Exception {

		System.out.println("LoginInterceptor------->afterCompletion------>整个完成之后，通常用于资源清理");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
