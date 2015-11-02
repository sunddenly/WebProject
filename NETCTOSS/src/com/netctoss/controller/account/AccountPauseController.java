package com.netctoss.controller.account;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.netctoss.dao.AccountMapperDao;
import com.netctoss.entity.Account;
import com.netctoss.entity.AccountPage;

@Controller
@RequestMapping("/account")
public class AccountPauseController {
	@Resource
	private AccountMapperDao dao;//太长往请求头里放@RequestHeader
	///NetCTOSS/account/pause/1005
	@RequestMapping(value="/pause/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public boolean pause(@PathVariable("id") Integer id){
		if(id != null){
			Timestamp time = new Timestamp(System.currentTimeMillis());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			map.put("time", time);
			dao.pauseAccount(map);
			return true;
		}
		return false;
	}
}
