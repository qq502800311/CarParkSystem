package org.gzhz.otherManage.test;

import java.util.HashMap;
import java.util.List;

import org.gzhz.otherManage.bean.CarVipTb;
import org.gzhz.otherManage.bean.Parameter_Tb;
import org.gzhz.otherManage.dao.CarVipMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUsers {
	@Test
	public void testUserLogin() {
		ApplicationContext conf = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(conf);
		CarVipMapper carMapper = conf.getBean(CarVipMapper.class);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();

		// hashMap.put("doctypeid", "1");
		//
		// hashMap.put("docname", "dcc.html");
		// hashMap.put("username", "admin");
		// hashMap.put("statdate", "2018-03-12");
		// hashMap.put("enddate", "2018-04-12");
		StringBuffer buffer = new StringBuffer("%闽D%");
		String dd = buffer.toString();
		System.out.println(buffer.toString());
		List<CarVipTb> carVipTbs = carMapper.findCarVipByName(buffer.toString());
		System.out.println(carVipTbs);
//		int dd=4;
//	Parameter_Tb parameter_Tb=	carMapper.findvipBytype();
//	System.out.println(parameter_Tb);
	}

}
