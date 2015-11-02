package com.netctoss.controller.fee;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.netctoss.dao.CostMapperDao;

@Controller
@RequestMapping("/fee")
public class FeeStartController {
	@Resource
	private CostMapperDao dao;
	@RequestMapping(value="/start/{id}",method=RequestMethod.GET)
	public String startFee(
			@PathVariable("id") int id){
	    Date date = new Date();//���ϵͳʱ��.
	    String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//��ʱ���ʽת���ɷ���TimestampҪ��ĸ�ʽ.
	    Timestamp time = Timestamp.valueOf(nowTime);//��ʱ��ת��
	    Map<String,Object> map =new HashMap<String, Object>();
	    map.put("id", id);
	    map.put("default", time);
		dao.startFee(map);
		return "redirect:/fee/list/1";
	}
}
