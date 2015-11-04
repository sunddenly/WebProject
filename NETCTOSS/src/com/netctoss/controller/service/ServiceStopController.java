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
public class ServiceStopController {
	@Resource
	private ServiceMapperDao dao;//太长往请求头里放@RequestHeader
	
	//NetCTOSS/service/start/2001/////NetCTOSS/service/start/2001
	@RequestMapping(value="/stop/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public boolean Start(
			@PathVariable("id") Integer id){
		if(id != null){
			dao.serviceStop(id);
			return true;
		}
		return false;
	}
}
