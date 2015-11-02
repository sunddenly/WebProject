package com.netctoss.dao;

import java.util.List;
import java.util.Map;

import com.netctoss.entity.Account;
import com.netctoss.entity.AccountPage;
import com.netctoss.entity.Cost;
import com.netctoss.entity.Page;
import com.netctoss.util.MyBatisDao;

@MyBatisDao
public interface AccountMapperDao {
	public List<Account> findByCondition(AccountPage page);
	public int findRows(AccountPage page);
	public Account findAccountById(Integer id);
	public void addAccount(Account account);
	public void deleteAccountById(Integer id);
	public void pauseAccount(Map map);
	public void startAccount(Map map);
	public void updateAccount(Account account);
}
