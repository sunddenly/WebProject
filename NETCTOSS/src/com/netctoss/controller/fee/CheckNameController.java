package com.netctoss.controller.fee;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netctoss.dao.CostMapperDao;
import com.netctoss.entity.Cost;
//NetCTOSS/fee/check/5.9Ԫ�ײ�
@Controller
@RequestMapping("/fee")
@Transactional(readOnly=true)
public class CheckNameController {
	@Resource
	private CostMapperDao dao;
	
	@RequestMapping("/check/{name:.+}")
	@ResponseBody
	public boolean check(@PathVariable("name") String name){
		Cost cost = dao.findByName(name);
		if(cost == null){
			return true;//û�м�¼ �����ʷ�������
		}else{
			return false;//�м�¼������������
		}
	}
}
