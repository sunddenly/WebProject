package com.netctoss.dao;

import java.util.List;

import com.netctoss.entity.Role;
import com.netctoss.util.MyBatisDao;
@MyBatisDao
public interface RoleMapperDao {
	public List<Role> findAll();
	public List<Role> findPage();
}
