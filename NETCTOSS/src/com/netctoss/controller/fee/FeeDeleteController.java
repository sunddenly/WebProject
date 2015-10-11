package com.netctoss.controller.fee;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netctoss.dao.CostMapperDao;
import com.netctoss.dao.RoleMapperDao;
import com.netctoss.entity.Cost;

@Controller
@RequestMapping("/fee")
@Transactional
public class FeeDeleteController {
	@Resource
	private CostMapperDao dao;
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	@ResponseBody//以json方式返回
	public boolean execute(@PathVariable(value="id") Integer id){
		if(id!=null){
			dao.deleteCost(id);
		}
		return true;
	}
}
