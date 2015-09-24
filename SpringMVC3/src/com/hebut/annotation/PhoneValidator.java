package com.hebut.annotation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
/**
 * 注解@phone的校验器，实现以下验证逻辑
 * 非空，而且必须是以13，15，18开始的手机号
 * 校验phone注解的string类型
 *
 */
public class PhoneValidator implements ConstraintValidator<Phone, String>{
	private String phoneReg="^1[3|5|8]\\d{9}$";
	private Pattern phonePattern = Pattern.compile(phoneReg);
	public void initialize(Phone constraintAnnotation) {
	
	}
	//检验方法
	public boolean isValid(String value, ConstraintValidatorContext context) {
		//校验逻辑
		if(value!=null&&!"".equals(value)){
			Matcher matcher = phonePattern.matcher(value);
			return matcher.matches();//返回是否匹配
		}else{
			return false;
		}
	}

}
