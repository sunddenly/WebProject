package com.netctoss.dao;

import java.util.List;

import com.netctoss.entity.Page;
import com.netctoss.entity.vo.ServiceLine;
import com.netctoss.entity.vo.ServicePage;
import com.netctoss.util.MyBatisDao;
@MyBatisDao
public interface ServiceMapperDao {
	public List<ServiceLine> findByCondition(ServicePage servicePage);
}
