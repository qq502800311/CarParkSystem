package org.gzhz.otherManage.test;

import java.util.HashMap;
import java.util.List;

import org.gzhz.manage.bean.Emp;
import org.gzhz.otherManage.bean.CarVipTb;
import org.gzhz.otherManage.bean.LogTb;
import org.gzhz.otherManage.bean.Parameter_Tb;
import org.gzhz.otherManage.dao.CarPortMapper;
import org.gzhz.otherManage.dao.CarVipMapper;
import org.gzhz.otherManage.dao.CrewSchedulingMapper;
import org.gzhz.otherManage.dao.SystemLogMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUsers {
	@Test
	public void testUserLogin() {
		ApplicationContext conf = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(conf);
		SystemLogMapper systemlogmappermapper = conf.getBean(SystemLogMapper.class);
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("starttime_systemlog", "");
		hashMap.put("endtime_systemlog", "");
		hashMap.put("emp_name", "");
		List<LogTb> i= systemlogmappermapper.selectlog(hashMap);
		// hashMap.put("doctypeid", "1");
		//
		// hashMap.put("docname", "dcc.html");
		// hashMap.put("username", "admin");
		// hashMap.put("statdate", "2018-03-12");
		// hashMap.put("enddate", "2018-04-i
		System.out.println(i);
//		int dd=4;
//	Parameter_Tb parameter_Tb=	carMapper.findvipBytype();
//	System.out.println(parameter_Tb);
	}
    @Test
    public void tee() {
    	String str = "ABC";
    	System.out.println(str.toUpperCase());
    }
}
