package com.netctoss.controller.account;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netctoss.dao.AccountMapperDao;
import com.netctoss.entity.Account;

@Controller
@RequestMapping("/account")
public class FindAccountController {
	@Resource
	private AccountMapperDao dao;
	@RequestMapping(value="/find",method=RequestMethod.POST)
	@ResponseBody
	public Account execute(
		@RequestParam("idcardNo") String idCard){
		Account account = dao.findAccountByIdcardno(idCard);	
		return account;
	}

}
