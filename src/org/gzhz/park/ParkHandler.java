package org.gzhz.park;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gzhz.park.dao.ICarInfoDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年4月12日 上午8:31:27 
* @version 1.0 
* @description 用于处理所有有关停车场的业务  
*/

@Controller //此注释的含义是将该类设置成为浏览器提交的上来的类
@RequestMapping("/park")
public class ParkHandler {
	@Resource
	private ICarInfoDao iCarInfoDao;
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月12日 下午08:21:49 
	* @version 1.0 
	* @parameter  无
	* @return  跳转到停车入口页面
	*/
	@RequestMapping("/entrance.action")
	public ModelAndView pageToEntrance(){
		System.out.println("显示停车场入口页面");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("enterCar");
		return mav;
	}
	
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月12日 下午08:45:49 
	* @version 1.0 
	* @parameter  HttpServletRequest request
	* @parameter  Stirng carLisence
	* @description 根据入口得到的车牌向车场表中添加车辆信息  
	* @return  true/false
	*/
	@RequestMapping(value="/entranceDisplay.action")
	public boolean pageToEntranceDisplay(HttpServletRequest request, String carLisence){
		boolean flag = false;
		System.out.println("得到的车牌号是："+carLisence);
//		iCarInfoDao
		
		
		return flag;
	}
	
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月12日 下午08:45:49 
	* @version 1.0 
	* @parameter  无
	* @return  跳转到首页
	*/
	@RequestMapping("/home.action")
	public ModelAndView pageToHome(){
		System.out.println("显示主页页面");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}
	
}
