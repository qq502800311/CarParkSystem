package org.gzhz.park;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.gzhz.park.bean.CarInfo;
import org.gzhz.park.dao.ICarInfoDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import bean.User;

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
	@RequestMapping(value="/entranceDisplay.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody CarInfo pageToEntranceDisplay(String carLisence){
		String flag = "false";
		System.out.println("得到的车牌号是："+carLisence);
		String date = "2018-04-13 13:52:56";
		CarInfo car = new CarInfo(carLisence,date);
		int i  = iCarInfoDao.partAddCar(car);
		if(i!=1){
			car = null;
		}else{
			flag = "true";
		}
		System.out.println("flag:"+flag);
		System.out.println("i:"+i);
		return car;
	}
	//localhost:8080/2018-04-08-mySpringMVC/index.jsp
		@RequestMapping(value="/userinfo3.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
		public @ResponseBody User userinfo3(String username, String password){
			System.out.println(username + ":" + password);
			System.out.println("userinfo3方法被调用了...");
			return new User(username, password);
		}
	
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月12日 下午15:45:49 
	* @version 1.0 
	* @parameter  MultipartFile fileact
	* @parameter  HttpSession session
	* @description 上传车辆照片 
	* @return  页面
	*/
	@RequestMapping(value="/fileact.action", method=RequestMethod.POST)
	public ModelAndView fileact(MultipartFile fileact,HttpSession session){
		String filename = fileact.getOriginalFilename();
		System.out.println("获取到的文件名:" + filename);
		if(filename.endsWith(".jpg")){
			System.out.println("符合要求");
			String path = session.getServletContext().getRealPath("/images");
			// 声明文件目录image，如果文件名不存在就建一个呗～
			File file = new File(path);
			if (!file.exists()) {
				System.out.println("目录不存在，新建文件");
				file.mkdirs();
			}
			System.out.println(path);
			try {
				fileact.transferTo(new File(path + "/" +filename));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
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
