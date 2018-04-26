package org.gzhz.park;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.gzhz.charge.bean.CarOutMsg;
import org.gzhz.charge.bean.CarPark;
import org.gzhz.manage.bean.Menu;
import org.gzhz.park.bean.CarInfo;
import org.gzhz.park.bean.CarPort;
import org.gzhz.park.bean.CarPortAndCarView;
import org.gzhz.park.bean.SearchPort;
import org.gzhz.park.dao.ICarInfoDao;
import org.gzhz.tool.CarChargeUnitl;
import org.gzhz.tool.CarParkUnitl;
import org.gzhz.tool.Log;
import org.gzhz.tool.MyDateUnitl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;

import bean.User;

/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年4月12日 上午8:31:27 
* @version 1.0 
* @description 用于控制所有有关停车场的业务分发
*/

@Controller //此注释的含义是将该类设置成为浏览器提交的上来的类
@RequestMapping("/park")
public class ParkHandler {
	@Resource
	private ICarInfoDao iCarInfoDao;
	@Resource
	private MyDateUnitl myDateUnitl;
	@Resource
	private CarParkUnitl carParkUnitl;
	@Resource
	private CarChargeUnitl carChargeUnitl;
	
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月12日 下午08:21:49 
	* @version 1.0 
	* @parameter  无
	* @return  跳转到停车入口页面
	*/
	//http://localhost:8080/CarParkSystem/park/entrance.action
	@RequestMapping("/entrance.action")
	public ModelAndView pageToEntrance(){
		System.out.println("显示停车场入口页面");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/carParkJsp/enterCar");
		return mav;
	}
	
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月18日 下午08:21:49 
	* @version 1.0 
	* @parameter  无
	* @return  跳转到车库停放页面 
	*/
	//http://localhost:8080/CarParkSystem/park/carPort.action
	@RequestMapping("/carPort.action")
	public ModelAndView pageToCarPort(){
		System.out.println("显示停车场车库界面");
		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/carParkJsp/carPort");
		mav.setViewName("/carParkJsp/carPort2");
		return mav;
	}
	
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月13日 下午14:50:49 
	* @version 1.0 
	* @parameter  无
	* @return  跳转到停车出口页面
	*/
	@RequestMapping("/export.action")
	public ModelAndView pageToExport(){
		System.out.println("显示停车场出口页面");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/carParkJsp/outCar");
		return mav;
	}
	
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月12日 下午08:21:49 
	* @version 1.0 
	* @parameter  无
	* @return  跳转到停车场鸟瞰图页面
	*/
	//http://localhost:8080/CarParkSystem/park/onview.action
	@RequestMapping("/onview.action")
	public ModelAndView pageToOnView(){
		System.out.println("显示停车场鸟瞰图页面");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/carParkJsp/carPortView");
		return mav;
	}
	
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月17日 上午10:23:49 
	* @version 1.0 
	* @parameter  无
	* @description 查询车场是否有空余车位  
	* @return  String flag
	*/
	@RequestMapping(value="/entranceDisplaySearch.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String displayPortStatus(){
		String flag = "false";
		int j = carParkUnitl.searchCarPort("未使用").size();
		if(j>0){
			System.out.println("车场有空余车位:" + j + "个");
			flag = "true";
		}
		flag = String.valueOf(j);
		return flag;
	}
	
	
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月12日 下午08:45:49 
	* @version 1.0 
	* @parameter  HttpServletRequest request
	* @parameter  Stirng carLisence
	* @description 根据入口得到的车牌向车场表中添加车辆信息  
	* @return  CarInfo car 
	*/
	@Log(operationType = "控制器", operationName = "得到时间")
	@RequestMapping(value="/entranceDisplay.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody CarInfo pageToEntranceDisplay(String carLisence){
		CarInfo car = null;
		String str = carParkUnitl.searchCarType(carLisence);
		System.out.println("当前车辆属于什么用户:" + str);
		car = carParkUnitl.addCar(carLisence);
		return car;
	}
	
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月12日 下午08:45:49 
	* @version 1.0 
	* @parameter  HttpServletRequest request
	* @parameter  Stirng carLisence
	* @description 根据出口得到的车牌信息进行处理
	* @return  CarInfo car 
	*/
	@RequestMapping(value="/exportDisplay.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody CarInfo pageToExportDisplay(String carLisence){
		System.out.println("得到的车牌号是："+carLisence);
		CarInfo car = carParkUnitl.deleteCar(carLisence);
		return car;
	}
	
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月12日 下午15:45:49 
	* @version 1.0 
	* @parameter  MultipartFile fileact
	* @parameter  HttpSession session
	* @description 入口上传车辆照片 -------------旧的表格提交
	* @return  页面
	*/
	
	@RequestMapping(value="/entranceFileact.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody CarInfo entranceFileact(MultipartFile fileact,HttpServletRequest  request){
		CarInfo car = null;
		ServletContext servletContext = request.getServletContext();
		String str = carParkUnitl.getImage(fileact, servletContext, "入口");
		System.out.println("图片存储路径为:" + str);
		String carLicense = carParkUnitl.recognitionCarImage(str);
		car = carParkUnitl.addCar(carLicense);
		return car;
	}
	
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月17日 下午19:16:49 
	* @version 1.0 
	* @parameter  MultipartFile fileact
	* @parameter  HttpServletRequest request
	* @description 入口上传车辆照片 ajax方式实现------重要
	* @return  CarInfo car
	*/
//	, produces="application/json;charset=utf-8"
	@RequestMapping(value = "/upload.action", method = RequestMethod.POST)
    public @ResponseBody CarInfo upload(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        CarInfo car = null;
		ServletContext servletContext = request.getServletContext();
		String str = carParkUnitl.getImage(file, servletContext, "入口");
		System.out.println("图片存储路径为:" + str);
		String carLicense = carParkUnitl.recognitionCarImage(str);
		car = carParkUnitl.addCar(carLicense);
		return car;
    }
	
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月18日 上午08:32:49 
	* @version 1.0 
	* @parameter  MultipartFile fileact
	* @parameter  HttpServletRequest request
	* @description 停车入库上传车辆照片 ajax方式实现------重要
	* @return  CarInfo car
	*/
//	, produces="application/json;charset=utf-8"
	@RequestMapping(value = "/carPortUploadIn.action", method = RequestMethod.POST)
    public @ResponseBody CarInfo carPortUploadIn(HttpServletRequest request, @RequestParam("file") MultipartFile file, String inCarPort_num) {
        CarInfo car = null;
        System.out.println(inCarPort_num);
		ServletContext servletContext = request.getServletContext();
		String str = carParkUnitl.getImage(file, servletContext, "入库");	//得到图片的存储路径
		String carLicense = carParkUnitl.recognitionCarImage(str);			//根据路径找到图片并识别车牌
		//对图片的文件路径进行处理
		String test = StringUtils.substringAfterLast(str,"CarParkSystem/");
        System.out.println("截取的字符串后结果:" + test);
        //查询参数表中车位使用中的ID
        Integer pid = iCarInfoDao.searchParameterIDByName("使用中");
		//根据图片路径和车库编号构建一个车库类
		CarPort cp = new CarPort(inCarPort_num, test,pid);
		//查询参数表中车位使用中的参数对应ID,更新到车库类中
		int i = iCarInfoDao.updateCarPortTB(cp);
		if(i == 1){
			System.out.println("车位表更新成功");
		}
		//将车库类提交更新到车库表,并得到该车位的ID
		CarPort cp2 = iCarInfoDao.searchCarPortID(cp);
		//将ID与车牌构建一个车辆类
		car = new CarInfo(carLicense, cp2.getCarport_id());
		//将车辆类提交更新到车辆表
		int j = iCarInfoDao.updateCarParkTB(car);
		if(j == 1){
			System.out.println("车辆表更新成功");
		}
		//检查以上操作的标志位，返回标志位。
		if((i==0) || (j==0)){
			car = null;
		}
		return car;
    }

	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月18日 上午08:32:49 
	* @version 1.0 
	* @parameter  MultipartFile fileact
	* @parameter  HttpServletRequest request
	* @description 停车出库上传车辆照片 ajax方式实现------重要
	* @return  CarInfo car
	*/
//	, produces="application/json;charset=utf-8"
	@RequestMapping(value = "/carPortUploadOut.action", method = RequestMethod.POST)
    public @ResponseBody CarInfo carPortUploadOut(HttpServletRequest request, @RequestParam("file") MultipartFile file, String outCarPort_num) {
        CarInfo car = null;
        System.out.println(outCarPort_num);
		ServletContext servletContext = request.getServletContext();
		String str = carParkUnitl.getImage(file, servletContext, "出库");	//得到图片的存储路径
		String carLicense = carParkUnitl.recognitionCarImage(str);			//根据路径找到图片并识别车牌
		//查询参数表中车位使用中的ID
        Integer pid = iCarInfoDao.searchParameterIDByName("未使用");
		//根据图片路径和车库编号构建一个车库类
		CarPort cp = new CarPort(outCarPort_num, "无",pid);
		//查询参数表中车位使用中的参数对应ID,更新到车库类中
		int i = iCarInfoDao.updateCarPortTB(cp);
		if(i == 1){
			System.out.println("车位表更新成功");
		}
		//将ID与车牌构建一个车辆类
		car = new CarInfo(carLicense, 0);//车辆出库后无法再将Integer字段内容设置为null，所以选择0，表示已经出库。
		//将车辆类提交更新到车辆表
		int j = iCarInfoDao.updateCarParkTB(car);
		if(j == 1){
			System.out.println("车辆表更新成功");
		}
		//检查以上操作的标志位，返回标志位。
		if((i==0) || (j==0)){
			car = null;
		}
		return car;
    }
	
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月12日 下午15:45:49 
	* @version 1.0 
	* @parameter  MultipartFile file
	* @parameter  HttpServletRequest request
	* @description 出口上传车辆照片 --------------新版ajax方式
	* @return  页面
	 * @throws ParseException 
	*/
	@RequestMapping(value = "/exportFileact.action", method = RequestMethod.POST)
	public @ResponseBody CarOutMsg exportFileact(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws ParseException {
		CarInfo car = null;
		ServletContext servletContext = request.getServletContext();
		String str = carParkUnitl.getImage(file, servletContext, "出口");
		System.out.println("图片存储路径为:" + str);							//上传图片完毕
		String carLicense = carParkUnitl.recognitionCarImage(str);			//根据返回的图片地址识别车牌号

		CarPark carPark = new CarPark();
		carPark.setCar_park_license(carLicense);
		CarOutMsg carOutMsg = carChargeUnitl.chargeCarOut(carPark);			//调用黄彪华的计费接口得到计费结果类
		car = carParkUnitl.deleteCar(carLicense);							//车辆离开删除车场记录
		return carOutMsg;
	}
	
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月12日 下午08:21:49 
	* @version 1.0 
	* @parameter  无
	* @return  跳转到车场查询页面
	*/
	//http://localhost:8080/CarParkSystem/park/pageToSearchCarInfo.action
	@RequestMapping("/pageToSearchCarInfo.action")
	public ModelAndView pageToSearchCarInfo(){
		System.out.println("显示停车场车辆查询页面");
		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/zwhJsp/empLogin");
		mav.setViewName("/carParkJsp/carPark_search");
		return mav;
	}
	
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月12日 下午08:45:49 
	* @version 1.0 
	* @parameter  HttpServletRequest request
	* @parameter  Stirng carLisence
	* @description 查询车场车辆信息
	* @return  CarInfo car 
	*/
	@RequestMapping(value="/searchCarInfo.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String searchCarInfo(SearchPort sp , int pageNum, int pageSize){
		System.out.println("要搜索的车牌是："+sp.getSearch_license());
		System.out.println("要搜索的车辆类型是："+sp.getSearch_carType());
		System.out.println("要搜索的车辆进入时间是："+"从"+sp.getSearch_date1()+"到"+sp.getSearch_date2());
		System.out.println("要搜索的车辆所在分区是："+sp.getSearch_area());
		System.out.println("页数："+pageNum+"pageSize:"+pageSize);
		//对提交的数据进行处理开始
		if(sp.getSearch_carType().length()==0){
			sp.setSearch_carType(null);
		}
		if(sp.getSearch_date1().length()==0){
			sp.setSearch_date1(null);
		}
		if(sp.getSearch_date2().length()==0){
			sp.setSearch_date2(null);
		}
		if(sp.getSearch_area().length()==0){
			sp.setSearch_area(null);
		}
		//对提交的数据进行处理结束
		PageHelper.startPage(pageNum, pageSize);
		;
		List<CarInfo> resultList = iCarInfoDao.searchCar(sp);
		PageInfo<CarInfo> pageInfo = new PageInfo<CarInfo>(resultList);
		Gson gson = new Gson();
		String data = gson.toJson(pageInfo);
		System.out.println(data);
		return data;
	}
	
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月12日 下午08:21:49 
	* @version 1.0 
	* @parameter  无
	* @return  跳转到车位查询页面
	*/
	//http://localhost:8080/CarParkSystem/park/pageToSearchCarPort.action
	@RequestMapping("/pageToSearchCarPort.action")
	public ModelAndView pageToSearchCarPort(){
		System.out.println("显示停车场车位查询页面");
		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/zwhJsp/empLogin");
		mav.setViewName("/carParkJsp/carPort_search");
		return mav;
	}
	
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月12日 下午08:45:49 
	* @version 1.0 
	* @parameter  HttpServletRequest request
	* @parameter  Stirng carLisence
	* @description 查询车场的车位信息
	* @return  CarPort carport
	*/
	@RequestMapping(value="/searchCarPort.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String searchCarPort(String carPortID, String carPortArea,int pageNum,int pageSize){
		System.out.println("要搜索的车位编号是：" + carPortID);
		System.out.println("要搜索的车位区域是：" + carPortArea);
		//对提交的数据进行处理开始
		if(carPortID.length()==0){
			carPortID = null;
		}
		if(carPortArea.length()==0){
			carPortArea = null;
		}
		Map<String,String> map = new HashMap<String,String>();
		map.put("carPortID", carPortID);
		map.put("carPortArea", carPortArea);
		//对提交的数据进行处理结束
		PageHelper.startPage(pageNum, pageSize);
		
		List<CarPort> resultList = iCarInfoDao.searchAllCarPort(map);
		PageInfo<CarPort> pageInfo = new PageInfo<CarPort>(resultList);
		Gson gson = new Gson();
		String data = gson.toJson(pageInfo);
		System.out.println(data);
		return data;
	}
	
	/** 
	* @author  作者 E-mail: 郭智雄
	* @date 创建时间：2018年4月24日 下午08:45:49 
	* @version 1.0 
	* @parameter  无
	* @description 查询所有车位与停放的车辆总视图信息————停车场鸟瞰图使用
	* @return  List<CarPortAndCarView>
	*/
	@RequestMapping(value="/searchAllCarParkAndCarInfo.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody String searchAllCarParkAndCarInfo(){	
		List<CarPortAndCarView> resultList = iCarInfoDao.getAllCarPortAndCarInfo();
				
		//对提交的数据进行处理结束
		Gson gson = new Gson();
		String data = gson.toJson(resultList);
		System.out.println(data);
		return data;
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
