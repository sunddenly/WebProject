package com.hebut;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Scope("singleton")
@Component("bar")
public class Bar {
	public Bar(){
		System.out.println("bar..");
	}
}
