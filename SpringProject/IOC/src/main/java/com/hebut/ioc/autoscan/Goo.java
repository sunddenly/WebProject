package com.hebut.ioc.autoscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.inject.Inject;

@Component
public class Goo {
	@Inject
	private Bar bar;
	public Bar getBar() {
		return bar;
	}
	@Autowired
	public void setBar(Bar bar) {
		this.bar = bar;
	}
	
}
