package com.netctoss.controller.account;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netctoss.dao.AccountMapperDao;
import com.netctoss.entity.Account;
import com.netctoss.entity.AccountPage;

@Controller
@RequestMapping("/account")
public class AccountAddController {
	@Resource
	private AccountMapperDao dao;//太长往请求头里放@RequestHeader
	
	@RequestMapping(value="/toAdd",method=RequestMethod.GET)
	public String toAdd(){
		return "account/accountadd";
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String Add(Account account){
		account.setStatus("0");
		Timestamp time = new Timestamp(System.currentTimeMillis());
		account.setCreate_date(time);
		dao.addAccount(account);
		return "redirect:/account/list/*/*/*/-1/1";
	}
}
