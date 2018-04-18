package org.gzhz.charge.test;
 /** 
* @author  作者 E-mail: 黄彪华
* @date 创建时间：2018年4月12日 下午3:12:56
* @version 1.03
* @parameter  
* @since  
* @return  
*/

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.gzhz.charge.bean.CarportUserMsg;
import org.gzhz.charge.dao.CarportUserMsgMapper;
import org.junit.Test;

import com.sun.glass.ui.Pixels.Format;



public class test {
	
	@Resource
	private CarportUserMsgMapper carport_msg;	
	
	@Test
	public void test() {
		
		
		//----------系统时间测试，现在及半年后--------------
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Calendar c = Calendar.getInstance();
		Calendar b = Calendar.getInstance();
		Calendar a = Calendar.getInstance();
		String now_time = df.format(c.getTime());     //获取系统的当前时间
		System.out.println("单前时间："+now_time);
		
		c.add(Calendar.MONTH, 1);
		String month_later = df.format(c.getTime());  //一个月后时间
		System.out.println("一个月后时间："+month_later);
		
		b.add(Calendar.MONTH, 3);
		String three_month = df.format(b.getTime());  //三个月后时间	
		System.out.println("三个月后时间："+three_month);
		
		a.add(Calendar.MONTH, 6);
		String half_year = df.format(a.getTime());    //半年后时间
		System.out.println("半年后时间："+half_year);	
	}
	


}
