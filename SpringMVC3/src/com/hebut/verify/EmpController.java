package com.hebut.verify;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class EmpController {
	
	@RequestMapping("/toUpdateEmp")
	public String toUpdate(Model model){
		System.out.println("----------Update");
		//从数据库中加载原来的输入信息
		Emp emp = new Emp();
		emp.setAge(45);
		emp.setName("汪峰");
		emp.setSex("M");
		emp.setDescr("鸟巢演唱会，向子怡求婚");
		emp.setCity("bj");
		emp.setFavor("3");
		emp.setFavs(new String[]{"a","b"});
		emp.setCities(new String[]{"bj","sh"});
		model.addAttribute("emp",emp);
		return "updateEmp";//进入updateEmp.jsp
	}
	//加载喜爱城市选项
	@ModelAttribute("cityMap")
	private Map<String, Object> getCities() {
		System.out.println("-----------getCities");
		Map<String,Object> cityMap = new HashMap<String,Object>();
		cityMap.put("bj","北京");
		cityMap.put("tj","天津");
		cityMap.put("sh","上海");
		cityMap.put("gz","广州");
		return cityMap;
	}
}
