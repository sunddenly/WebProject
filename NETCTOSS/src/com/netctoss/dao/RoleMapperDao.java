package com.netctoss.dao;

import java.util.List;

import com.netctoss.entity.Page;
import com.netctoss.entity.Role;
import com.netctoss.entity.RoleModule;
import com.netctoss.util.MyBatisDao;
@MyBatisDao
public interface RoleMapperDao {
	public List<Role> findAll();
	public List<Role> findPage(Page page);
	public int findRows();
	public void addRole(Role role);
	public void addRoleModule(RoleModule roleModule);
	public void deleteRoleModuleById(Integer id);
	public void deleteRoleById(Integer id);
	public void updateRole(Role role);
	public Role findById(Integer id);
	public List<Integer> findModuleIdByRoleId(Integer id);
}
