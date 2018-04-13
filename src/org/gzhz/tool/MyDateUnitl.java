package org.gzhz.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年4月2日 下午1:36:52 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
@Component
public class MyDateUnitl {
	// 获取当前日期的方法
	public String getNowDate() {
		String formatdate;
		// -------------------------------获取当前日期开始---------------------------------------//
		Date date = new java.util.Date();// 获取当前时间对象，也可以直接传入Date的对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置格式为时分秒
		formatdate = sdf.format(date);// 获取格式化日期
		System.out.println(formatdate);
		// -------------------------------获取当前日期结束---------------------------------------//
		return formatdate;
	}
	
	// 将带有时分秒的日期转化成只有年月日的
	static public String turnDateFormat(String dateString) {
		String resultDateString = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// Date date = null;
		if ((dateString == null)) {
			resultDateString = "暂无";
		} else if (dateString.equals("暂无")) {
			resultDateString = "暂无";
		} else {
			try {
				Date date = sdf.parse(dateString);
				resultDateString = sdf.format(date);// 获取格式化日期去掉时分秒
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resultDateString;
	}
}
