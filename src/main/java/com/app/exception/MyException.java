package com.app.exception;

import javax.jms.MessageFormatRuntimeException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyException implements HandlerExceptionResolver {

	/**
	 * OBJECT发生异常的地方+包名+类名+方法名
	 */
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception e) {
		ModelAndView mo = new ModelAndView();
		if(e instanceof MessageFormatRuntimeException) {
			//预期异常
			MessageFormatRuntimeException me = (MessageFormatRuntimeException) e;
			mo.addObject("error", me.getMessage());
		}else {
			mo.addObject("error", "错了吧");
			mo.setViewName("error");
		}
		
		return mo;
	}

}
