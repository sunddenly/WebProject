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
import org.springframework.web.bind.annotation.ResponseBody;

import com.netctoss.dao.AccountMapperDao;
import com.netctoss.entity.Account;
import com.netctoss.entity.AccountPage;

@Controller
@RequestMapping("/account")
public class AccountUpdateController {
	@Resource
	private AccountMapperDao dao;//太长往请求头里放@RequestHeader
	@RequestMapping(value="/{id}/toEdit",method=RequestMethod.GET)
	public String toUpdate(
			@PathVariable("id") Integer id,
			Model model){
		Account account = dao.findAccountById(id);
		model.addAttribute("account", account);
		return "account/accountmodi";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public boolean update(Account account){
		if(account !=null ){
			dao.updateAccount(account);
			return true;
		}
		return false;
	}
}
