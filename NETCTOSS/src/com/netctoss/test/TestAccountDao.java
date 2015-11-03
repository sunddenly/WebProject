package com.netctoss.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netctoss.dao.AccountMapperDao;
import com.netctoss.dao.AdminInfoMapperDao;
import com.netctoss.dao.CostMapperDao;
import com.netctoss.entity.Account;
import com.netctoss.entity.AccountPage;
import com.netctoss.entity.AdminInfo;
import com.netctoss.entity.Cost;
import com.netctoss.entity.Page;

public class TestAccountDao {
	public static void main(String[] args) {
		String conf = "com/netctoss/config/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		AccountMapperDao dao = ac.getBean("accountMapperDao",AccountMapperDao.class);
		//findCondition(dao);
		findAccountByIdcard(dao);
	}

	private static void findAccountByIdcard(AccountMapperDao dao) {
		Account account = dao.findAccountByIdcardno("330682196903190613");
		System.out.println(account.getAccount_id());
	}

	private static void findCondition(AccountMapperDao dao) {
		AccountPage page = new AccountPage();
		page.setPage(2);
		page.setStatus("-1");
		page.setLogin_name("*");
		page.setReal_name("*");
		page.setIdcard_no("*");
		int i = dao.findRows(page);
		System.out.println(i);
		List<Account> list = dao.findByCondition(page);
		for (Account account : list) {
			System.out.println(account.getAccount_id()+"," + account.getReal_name());
		}
	}
}
