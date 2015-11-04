package com.netctoss.controller.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netctoss.dao.AccountMapperDao;
import com.netctoss.dao.ServiceMapperDao;
import com.netctoss.entity.Account;
import com.netctoss.entity.AccountPage;

@Controller
@RequestMapping("/service")
public class ServiceStartController {
	@Resource
	private ServiceMapperDao dao;//太长往请求头里放@RequestHeader
	@Resource
	private AccountMapperDao adao;
	//NetCTOSS/service/start/2001/////NetCTOSS/service/start/2001
	@RequestMapping(value="/start/{id}",method=RequestMethod.POST)
	@ResponseBody
	public boolean Start(
			@RequestParam("no") String idCardno,
			@PathVariable("id") Integer id){
		Account account = adao.findAccountByIdcardno(idCardno);
		if(id != null&&!account.getStatus().equals("1")){
			dao.serviceStart(id);
			return true;
		}
		return false;
	}
}
