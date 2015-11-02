package com.netctoss.controller.account;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netctoss.dao.AccountMapperDao;
import com.netctoss.entity.Account;
import com.netctoss.entity.AccountPage;

@Controller
@RequestMapping("/account")
public class AccountListController {
	@Resource
	private AccountMapperDao dao;//̫��������ͷ���@RequestHeader
	@RequestMapping(value="/list/{idcard_no}/{real_name}/{login_name}/{status}/{p}",method=RequestMethod.GET)
	public String execute(
			@PathVariable("idcard_no") String idcard_no,
			@PathVariable("real_name") String real_name,
			@PathVariable("login_name") String login_name,
			@PathVariable("status") String status,
			@PathVariable("p") Integer p,
			Model model){
		AccountPage page = new AccountPage();
		//������ѯ��������
		page.setIdcard_no(idcard_no);
		page.setReal_name(real_name);
		page.setLogin_name(login_name);
		page.setStatus(status);
		page.setPage(p);
		//����AccountMapperDao��ѯ
		List<Account> list = dao.findByCondition(page);
		Account account = list.get(0);
		model.addAttribute("accounts",list);
		//ͳ����ҳ��
		int totalRows = dao.findRows(page);
		int totalPage = 0;
		if(totalRows%page.getPageSize()==0){
			totalPage = totalRows/page.getPageSize();
		}else{
			totalPage = totalRows/page.getPageSize()+1;
		}
		page.setTotalPage(totalPage);
		//������*���
		page.setIdcard_no(convert(page.getIdcard_no()));
		page.setReal_name(convert(page.getReal_name()));
		page.setLogin_name(convert(page.getLogin_name()));
		model.addAttribute("page",page);
		return "account/accountlist";
	}
	public String convert(String s){
		if("*".equals(s)){
			return "";
		}else{
			return s;
		}
	}
}
