package com.netctoss.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.ws.ResponseWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netctoss.dao.AdminInfoMapperDao;
import com.netctoss.entity.AdminInfo;
import com.netctoss.entity.Privilege;
import com.netctoss.entity.vo.AdminInfoPage;
import com.netctoss.util.PrivilegeReader;

@Controller
@RequestMapping("/admin")
public class ResetPwdController {
	@Resource
	private AdminInfoMapperDao dao;
	@RequestMapping(value="/resetpwd",method=RequestMethod.POST)
	@ResponseBody
	public boolean execute(
			@RequestParam("ids") String ids,
			Model model){
		if(ids!=null){
			//List<Integer> list = buildIdList(ids);
			//dao.resetPwd(list);
			return true;
		}else{
			return false;
		}
	}
	private List<Integer> buildIdList(String ids) {
		if(ids == null || ids.length() == 0)
			return null;
		List<Integer> list = new ArrayList<Integer>();
		String[] idsArray = ids.split(",");
		for(String id : idsArray) {
			list.add(Integer.valueOf(id));
		}
		return list;
	}
}
