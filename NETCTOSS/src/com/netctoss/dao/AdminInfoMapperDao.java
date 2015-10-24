package com.netctoss.dao;

import java.util.List;

import com.netctoss.entity.AdminInfo;
import com.netctoss.entity.vo.AdminInfoPage;
import com.netctoss.util.MyBatisDao;
@MyBatisDao
public interface AdminInfoMapperDao {
	public AdminInfo findByAdminCodeAndPwd(AdminInfo adminInfo);
	public List<AdminInfo> findByCondition(AdminInfoPage adminInfoPage);
}
