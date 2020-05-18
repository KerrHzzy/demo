package net.xdclass.demo.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author hdz
 */
public class TwoInterceptor implements HandlerInterceptor{

	/**
	 * 进入对应的controller方法之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request
							, HttpServletResponse response
							, Object handler) throws Exception {

		System.out.println("TwoInterceptor------>preHandle------>进入对应的controller方法之前");
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	/**
	 * controller处理之后，返回对应的视图之前
	 */
	@Override
	public void postHandle(HttpServletRequest request
							, HttpServletResponse response
							, Object handler
							, ModelAndView modelAndView) throws Exception {

		System.out.println("TwoInterceptor------>postHandle------>controller处理之后，返回对应的视图之前");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * 整个请求结束后调用，视图渲染后，主要用于资源的清理
	 */
	@Override
	public void afterCompletion(HttpServletRequest request
								, HttpServletResponse response
								, Object handler
								, Exception ex) throws Exception {

		System.out.println("TwoInterceptor------>afterCompletion------>整个请求结束后调用，视图渲染后，主要用于资源的清理");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
