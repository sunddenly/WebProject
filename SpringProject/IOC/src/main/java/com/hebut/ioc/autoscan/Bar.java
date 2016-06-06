package com.hebut.ioc.autoscan;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Scope("singleton")
@Component("bar")
public class Bar {
	public Bar(){
		System.out.println("bar..");
	}

	@Override
	public String toString() {
		return "Bar{-----String}";
	}
}
