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
		//��¼Ŀ������׳����쳣
		//ex���Խ���Ŀ���׳����쳣
		System.out.println("��¼�쳣��Ϣ��"+ex);
	}
}
