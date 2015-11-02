package com.netctoss.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netctoss.dao.AdminInfoMapperDao;
import com.netctoss.dao.CostMapperDao;
import com.netctoss.entity.AdminInfo;
import com.netctoss.entity.Cost;
import com.netctoss.entity.Page;

public class TestCostDao {
	public static void main(String[] args) {
		String conf = "com/netctoss/config/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		CostMapperDao dao = ac.getBean("costMapperDao",CostMapperDao.class);
//		Cost cost = new Cost();
//		cost.setName("sun");
//		dao.addCost(cost);
//		Cost cost = dao.findByName("5.9Ԫ�ײ�");
//		System.out.println(cost.getName());
	    Date date = new Date();//���ϵͳʱ��.
	    String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//��ʱ���ʽת���ɷ���TimestampҪ��ĸ�ʽ.
	    Timestamp time = Timestamp.valueOf(nowTime);//��ʱ��ת��
	    Map<String,Object> map =new HashMap<String, Object>();
	    map.put("id", 6);
	    map.put("default", time);
		dao.startFee(map);
	}
}
