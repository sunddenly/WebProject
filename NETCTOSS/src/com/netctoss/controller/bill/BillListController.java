package com.netctoss.controller.bill;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/bill")
public class BillListController {
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String execute(){
		return "bill/billlist";
	}
}
