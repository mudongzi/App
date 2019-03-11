package com.app.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 拦截器
* @Title: MyHandlerInterceptor 
* @Description:   
* @author xudong  
* @date 2019年1月16日
 */
public class MyHandlerInterceptor implements HandlerInterceptor {
	/**
	 * Controller执行前调用该方法
	 * 返回值为true 表示继续执行，false终止执行
	 * 可以验证登录，权限等拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("进入拦截器");
		return false;
	}
	/**
	 * controller 执行后未返回视图前调用此方法
	 * 用途：再返回用户前对模型数据进行加工处理，比如加入公共信息
	 * 以便页面显示
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}
	/**
	 * controller执行后并且是调用了结果视图后才调用该方法
	 * 这里可以得到执行controller时的异常信息
	 * 用途：可以记录操作日志
	 * 
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
