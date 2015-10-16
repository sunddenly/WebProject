package com.netctoss.entity.vo;

import com.netctoss.entity.Service;

public class ServiceLine extends Service{
	private String idcard_no;
	private String real_name;
	private String cost_name;
	private String cost_descr;
	
	public String getIdcard_no() {
		return idcard_no;
	}
	public void setIdcard_no(String idcard_no) {
		this.idcard_no = idcard_no;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getCost_name() {
		return cost_name;
	}
	public void setCost_name(String cost_name) {
		this.cost_name = cost_name;
	}
	public String getCost_descr() {
		return cost_descr;
	}
	public void setCost_descr(String cost_descr) {
		this.cost_descr = cost_descr;
	}
	
}
