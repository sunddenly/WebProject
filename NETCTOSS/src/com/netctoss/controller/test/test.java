package com.netctoss.controller.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.netctoss.entity.Privilege;
import com.netctoss.util.PrivilegeReader;

public class test {
	public static void main(String[] args) {
       testMysqlTime();
//       List<Privilege> list = PrivilegeReader.getPrivileges();
//       for (Privilege privilege : list) {
//    	   System.out.println(privilege.getId());
//       }
       Timestamp timestamp = new Timestamp(System.currentTimeMillis());
       Date date = new Date(timestamp.getTime());
       System.out.println(date);
	}

	private static void testMysqlTime() {
		Date date = new Date(System.currentTimeMillis());//获得系统时间.
		String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//将时间格式转换成符合Timestamp要求的格式.
		   Timestamp goodsC_date = Timestamp.valueOf(nowTime);//把时间转换
		   Map<String,Object> map =new HashMap<String, Object>();
	}
}
