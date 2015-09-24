package com.hebut.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 定义一个phone注解标记，并指定为注解的实现
 * 指定注解的使用范围：字段前，方法前均可使用
 * 注解的有效性：运行时有效
 * 定义注解属性
 */
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=PhoneValidator.class)//标记如下定义是一个约束注解
public @interface Phone {
	//定义message属性
	String message() default "";
	//定义groups属性
	Class<?>[] groups() default{};
	//定义Payload属性
	Class<? extends Payload>[] payload() default{}; 
}
