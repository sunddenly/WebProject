package com.netctoss.controller.report;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("report")
public class ReportListController {
	@RequestMapping(value="list",method=RequestMethod.GET)
	public String execute(){
		return "report/reportlist";
	}
}
