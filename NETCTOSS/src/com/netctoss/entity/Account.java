package com.netctoss.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author jxy
 *
 */
public class Account implements Serializable{
	private Integer account_id;
	private Integer recommender_id;
	private String login_name;
	private String login_passwd;
	private String status;
	private Date create_date;
	private Date pause_date;
	private Date close_date;
	private String real_name;
	private String idcard_no;
	private Date birthdate;
	private String gender;
	private String occupation;
	private String telephone;
	private String email;
	private String mailaddress;
	private String zipcode;
	private String qq;
	private Date last_login_time;
	private String last_login_ip;
	public Integer getAccount_id() {
		return account_id;
	}
	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}
	public Integer getRecommender_id() {
		return recommender_id;
	}
	public void setRecommender_id(Integer recommender_id) {
		this.recommender_id = recommender_id;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getLogin_passwd() {
		return login_passwd;
	}
	public void setLogin_passwd(String login_passwd) {
		this.login_passwd = login_passwd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getPause_date() {
		return pause_date;
	}
	public void setPause_date(Date pause_date) {
		this.pause_date = pause_date;
	}
	public Date getClose_date() {
		return close_date;
	}
	public void setClose_date(Date close_date) {
		this.close_date = close_date;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getIdcard_no() {
		return idcard_no;
	}
	public void setIdcard_no(String idcard_no) {
		this.idcard_no = idcard_no;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMailaddress() {
		return mailaddress;
	}
	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public Date getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}
	public String getLast_login_ip() {
		return last_login_ip;
	}
	public void setLast_login_ip(String last_login_ip) {
		this.last_login_ip = last_login_ip;
	}
	
	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", recommender_id="
				+ recommender_id + ", login_name=" + login_name
				+ ", login_passwd=" + login_passwd + ", status=" + status
				+ ", create_date=" + create_date + ", pause_date=" + pause_date
				+ ", close_date=" + close_date + ", real_name=" + real_name
				+ ", idcard_no=" + idcard_no + ", birthdate=" + birthdate
				+ ", gender=" + gender + ", occupation=" + occupation
				+ ", telephone=" + telephone + ", email=" + email
				+ ", mailaddress=" + mailaddress + ", zipcode=" + zipcode
				+ ", qq=" + qq + ", last_login_time=" + last_login_time
				+ ", last_login_ip=" + last_login_ip + ", getAccount_id()="
				+ getAccount_id() + ", getRecommender_id()="
				+ getRecommender_id() + ", getLogin_name()=" + getLogin_name()
				+ ", getLogin_passwd()=" + getLogin_passwd() + ", getStatus()="
				+ getStatus() + ", getCreate_date()=" + getCreate_date()
				+ ", getPause_date()=" + getPause_date() + ", getClose_date()="
				+ getClose_date() + ", getReal_name()=" + getReal_name()
				+ ", getIdcard_no()=" + getIdcard_no() + ", getBirthdate()="
				+ getBirthdate() + ", getGender()=" + getGender()
				+ ", getOccupation()=" + getOccupation() + ", getTelephone()="
				+ getTelephone() + ", getEmail()=" + getEmail()
				+ ", getMailaddress()=" + getMailaddress() + ", getZipcode()="
				+ getZipcode() + ", getQq()=" + getQq()
				+ ", getLast_login_time()=" + getLast_login_time()
				+ ", getLast_login_ip()=" + getLast_login_ip()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	

}
