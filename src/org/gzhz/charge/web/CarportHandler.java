package org.gzhz.charge.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gzhz.charge.bean.CarportUserMsg;
import org.gzhz.charge.bean.Meal;
import org.gzhz.charge.dao.CarportUserMsgMapper;
import org.gzhz.charge.dao.MealMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

/** 
* @author  作者 E-mail: 黄彪华
* @date 创建时间：2018年4月12日 上午11:28:13
* @version 1.03
* @parameter  
* @since  
* @return  
*/


@Controller
@RequestMapping("/carport")
public class CarportHandler {
	
	@Resource
	private CarportUserMsgMapper carport_msg;
	@Resource
	private MealMapper meal_mapper;
	
	/** 
	* @date 创建时间：2018年4月12日 下午14:28:13
	* @parameter  
	* @since  
	* @return  返回车位信息对象，传到ajax显示在界面
	*/
	@RequestMapping(value="/checkParkMsg.action",method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody CarportUserMsg findCarportMsg(String check_msg) {
		System.out.println("收到ajax的数据:"+check_msg);
		
		List<CarportUserMsg> carport_msg_list = carport_msg.findAllMsg();
		System.out.println("获取的车位信息列表:"+carport_msg_list);
		CarportUserMsg carport = carport_msg_list.get(0);
		
		System.out.println("剩余车位数:"+carport.getCarport_remain_num());
		System.out.println("使用中车位数:"+carport.getCarport_using_num());
		
	return carport;
	}
	
	/** 
	* @date 创建时间：2018年4月12日 下午16:21:15
	* @parameter  
	* @return  返回套餐信息列表，显示在界面表格
	*/
	@RequestMapping(value="/searchMealMsg.action",method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String findMealMsg(String meal_msg) {
		System.out.println("收到ajax的数据:"+meal_msg);
		
		List<Meal> meals = meal_mapper.findAllMeal();
		System.out.println("获取的套餐列表:"+meals);
		Gson gson = new Gson();
		String date = gson.toJson(meals);
		System.out.println(meals);
	return date;
	}
}



























