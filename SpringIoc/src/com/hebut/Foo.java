package com.hebut;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component("foo")
public class Foo {
	public Foo() {
		System.out.println("foo....");
	}
	@PostConstruct
	public void f1(){//初始化回调
		System.out.println("foo111");
	}
	@PreDestroy
	public void f2(){//销毁回调
		System.out.println("foo111");
	}
}
