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
public class AccountDeleteController {
	@Resource
	private AccountMapperDao dao;//太长往请求头里放@RequestHeader
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public boolean execute(@PathVariable("id") Integer id){
		if(id != null){
			dao.deleteAccountById(id);
			return true;
		}
		return false;
	}
}
