package com.hebut.annotation;

import org.springframework.stereotype.Repository;

//Ïàµ±ÓÚ extends Repository
@Repository
public @interface MybatisDao {
	String value() default "";
}
