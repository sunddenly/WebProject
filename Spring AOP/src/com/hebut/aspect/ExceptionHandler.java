package com.hebut.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class ExceptionHandler {
	@AfterThrowing(pointcut="within(com.hebut.dao..*)",throwing="ex")
	public void myrun(Exception ex){
		//记录目标组件抛出的异常
		//ex可以接受目标抛出的异常
		System.out.println("记录异常信息："+ex);
	}
}
