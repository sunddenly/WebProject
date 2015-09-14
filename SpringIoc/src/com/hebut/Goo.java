package com.hebut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Goo {
	private Bar bar;

	public Bar getBar() {
		return bar;
	}

	@Autowired
	public void setBar(Bar bar) {
		this.bar = bar;
	}
	
}
