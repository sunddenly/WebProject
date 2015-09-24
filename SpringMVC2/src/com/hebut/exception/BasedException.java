package com.hebut.exception;

import java.io.IOError;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class BasedException implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse arg1, Object method, Exception ex) {
			System.out.println(method);
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("ex", ex);
			if(ex instanceof IOException){
				return new ModelAndView("error1",data);
			}else if(ex instanceof SQLException){
				return new ModelAndView("error2",data);
			}else{
				return new ModelAndView("error",data);
			}
	}

}
