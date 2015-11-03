package com.netctoss.dao;

import java.util.List;
import java.util.Map;

import com.netctoss.entity.Cost;
import com.netctoss.entity.Page;
import com.netctoss.entity.Service;
import com.netctoss.entity.vo.ServiceLine;
import com.netctoss.entity.vo.ServicePage;
import com.netctoss.util.MyBatisDao;
@MyBatisDao
public interface ServiceMapperDao {
	public List<ServiceLine> findByCondition(ServicePage servicePage);
	public Integer findRows();
	public ServiceLine findServiceById(Integer id);
	public List<Cost> findCostName();
	public String validateOsusername(Map map);
	public void addService(Service service);
}
