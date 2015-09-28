package com.netctoss.dao;

import com.netctoss.entity.AdminInfo;
import com.netctoss.util.MyBatisDao;
@MyBatisDao
public interface AdminInfoMapperDao {
	public AdminInfo findByAdminCodeAndPwd(AdminInfo adminInfo);
}
