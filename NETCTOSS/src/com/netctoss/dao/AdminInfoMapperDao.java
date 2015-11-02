package com.netctoss.dao;

import java.util.List;

import com.netctoss.entity.AdminInfo;
import com.netctoss.entity.AdminRole;
import com.netctoss.entity.vo.AdminInfoPage;
import com.netctoss.util.MyBatisDao;
@MyBatisDao
public interface AdminInfoMapperDao {
	public AdminInfo findByAdminCodeAndPwd(AdminInfo adminInfo);
	public Integer findRows(AdminInfoPage adminInfoPage);
	public List<Integer> findRoleId(Integer id);
	public AdminInfo findById(Integer id);
	public List<AdminInfo> findByCondition(AdminInfoPage adminInfoPage);
	public AdminInfo findByName(String name);
	public void addAdminRole(AdminRole adminRole);
	public void addAdmin(AdminInfo adminInfo);
	public void resetPwd(List list);
	public void deleteAdminRoleById(Integer id);
	public void deleteAdminById(Integer id);
	public void updateAdminInfo(AdminInfo info);
	
}
