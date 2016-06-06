package com.hebut.ioc.autoscan;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component("fooName")
public class Foo {
	public Foo() {
		System.out.println("foo....");
	}
	@PostConstruct
	public void f1(){//��ʼ���ص�
		System.out.println("foo111");
	}
	@PreDestroy
	public void f2(){//���ٻص�
		System.out.println("foo111");
	}
}
