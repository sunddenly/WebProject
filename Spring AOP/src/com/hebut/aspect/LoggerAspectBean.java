package com.hebut.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class LoggerAspectBean {
	//@Before("within(com.hebut.dao..*)")
	@Before("!execution(* find* (..))")
	public void mylog(){
		System.out.println("--记录用户操作--");
	}
}
