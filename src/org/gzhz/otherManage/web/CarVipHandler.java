package org.gzhz.otherManage.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gzhz.charge.bean.CarOutMsg;
import org.gzhz.charge.bean.CarPark;
import org.gzhz.charge.bean.ChargeRule;
import org.gzhz.charge.dao.CarParkMapper;
import org.gzhz.charge.dao.ChargeRuleMapper;
import org.gzhz.manage.bean.Menu;
import org.gzhz.otherManage.bean.CarVipTb;
import org.gzhz.otherManage.dao.CarVipMapper;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;

/**
 * @author: 詹良斌
 * @date 创建时间 2018年4月12日 下午1:48:18
 * @Project: CarParkSystem
 * @version V1.0
 * @parameter *正式*针对用户表建立的用户类
 * @since
 * @return
 * @Description: TODO
 */
@Controller
@RequestMapping("/car")
public class CarVipHandler {

	@Resource
	private CarVipMapper carvipmapper;
	
	@Resource
	private ChargeRuleMapper chargeRule;
	
	@Resource
	private CarParkMapper carParkDao;

	// 查询车牌
	@RequestMapping(value = "/vipsearch", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String vipcarinfo(HttpServletRequest request, String car_park_license , int pageNum, int pageSize) {
		// String car_park_license 前端发来数据
		StringBuffer buffer = null;
		String carparklicense = null;
		if (!car_park_license.equals("") || car_park_license == null) {
			buffer = new StringBuffer("%");
			buffer.append(car_park_license);
			buffer.append("%");
			carparklicense = buffer.toString();
		}
		PageHelper.startPage(pageNum, pageSize);
		List<CarVipTb> carVipTbs = carvipmapper.findCarVipByName(carparklicense);
		PageInfo<CarVipTb> pageInfo = new PageInfo<CarVipTb>(carVipTbs);
//		System.out.println(carparklicense);
		System.out.println("vipcarinfo方法被调用了...");
//		System.out.println(carVipTbs);
		Gson gson = new Gson();

		String documentstring = gson.toJson(pageInfo);
//		System.out.println(documentstring);
		return documentstring;
	}

	// 修改车牌
	@RequestMapping(value = "/vipcarmodifier", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String vipcarmodifier(String currentcarparklicense,
			String modifiercarparkchangeCarparklicense) {
		System.out.println(currentcarparklicense + "=" + modifiercarparkchangeCarparklicense);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("currentcarparklicense", currentcarparklicense);
		map.put("modifiercarparkchangeCarparklicense", modifiercarparkchangeCarparklicense);
		carvipmapper.changevipcarbrand(map);

		return null;

	}

	// 删除车牌
	@RequestMapping(value = "/deletevipcar", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String deletevipcar(String currentcarparklicense) {
		carvipmapper.deletevip(currentcarparklicense);

		// carvipmapper;

		return null;

	}

	// 增加车牌
	@RequestMapping(value = "/addvipcar", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String addvipcar(String newvip_Name) {
		System.out.println(newvip_Name);
		CarVipTb carVipTb = new CarVipTb();
		carVipTb.setCar_park_license(newvip_Name);
		carVipTb.setCar_park_type(4);
		carvipmapper.addvip(carVipTb);

		return null;

	}

	// 监测是否重名车牌
	@RequestMapping(value = "/checkcarparklicense", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String checkcarparklicense(String newvip_Name) throws IOException {
		System.out.println("newvip_Name" + newvip_Name);
		CarVipTb carVipTb = new CarVipTb();
		carVipTb.setCar_park_license(newvip_Name);

		String msg = null;

		CarVipTb carVipTb2 = null;

		try {
			carVipTb2 = carvipmapper.carvipfindByName(carVipTb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (carVipTb2 != null) {
			System.out.println("用户已存在");
			msg = "no";
		} else {
			msg = "yes";

			System.out.println("不存在");

		}
		Gson gson = new Gson();
		String msginfo = gson.toJson(msg);
		return msginfo;

	}

	// 监测是否重名车牌
	@RequestMapping(value = "/checkmodifcarparklicense", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String checkmodifcarparklicense(String modifiercarparkchangeCarparklicense) throws IOException {
		System.out.println("modifiercarparkchangeCarparklicense" + modifiercarparkchangeCarparklicense);
		CarVipTb carVipTb = new CarVipTb();
		carVipTb.setCar_park_license(modifiercarparkchangeCarparklicense);

		String msg = null;

		CarVipTb carVipTb2 = null;

		try {
			carVipTb2 = carvipmapper.carvipfindByName(carVipTb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (carVipTb2 != null) {
			System.out.println("用户已存在");
			msg = "no";
		} else {
			msg = "yes";

			System.out.println("不存在");

		}
		Gson gson = new Gson();
		String msginfo = gson.toJson(msg);
		return msginfo;

	}
	
	//页面跳转
	//http://localhost:8080/CarParkSystem/car/pageTocarvip.action
	@RequestMapping("/pageTocarvip")
	public ModelAndView pageTocarvip() {
		ModelAndView modelAndView= new ModelAndView("zlbjsp/vip_search");
		return modelAndView;
	}
	
	//费用查询

	// 查询车牌
	@RequestMapping(value = "/carfeiyong", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String carfeiyong(String car_name) throws ParseException, UnsupportedEncodingException {
		System.out.println(car_name);
		car_name=URLDecoder.decode(car_name,"UTF-8");
		System.out.println(car_name);
		CarPark carPark =new  CarPark();
    	carPark.setCar_park_license(car_name);
    	String msgjson=null;
		
		int total_money = 0;
		int fir = 0;
		int sec = 0;
		int thr = 0;
		int fur = 0;
		int fiv = 0;	
    	CarPark car = carParkDao.searchCarParkMsg(carPark);

    	if (car == null) {
    		 System.out.println("查无此车");
    		 msgjson=new Gson().toJson("查无此车停车记录");
    	}else {
    		System.out.println(car.getCarport_id());
    		String car_type = car.getParameter().getParameter_name();
			String start_time = car.getCar_in_time();
			//---------------计算费用---------
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar c = Calendar.getInstance();
			String now_time = df.format(c.getTime());
			
			//计算时间差
			long from = df.parse(start_time).getTime();
			long to = df.parse(now_time).getTime();  
			int minutes = (int) ((to - from)/(1000 * 60)); 
			System.out.println("停车时间:"+minutes);
			
			//获取收费规则信息
			List<ChargeRule> rules = chargeRule.findChargeRule();
			if(rules.size()!=0) {
				System.out.println("收费规则表获取成功");
			}else {
				System.out.println("收费规则表获取失败");
			}

			for (int i = 0; i < rules.size(); i++) {
				fir = rules.get(0).getCharge_rule_1();
				sec = rules.get(0).getCharge_rule_2();
				thr = rules.get(0).getCharge_rule_3();
				fur = rules.get(0).getCharge_rule_4();
				fiv = rules.get(0).getCharge_rule_5();
			}
			
			System.out.println("停车时间2:"+minutes);
			//计算费用
			System.out.println("汽车类型:" +car_type);
			if(!car_type.equals("临时车辆")) {
				total_money = 0;
			}else {
				if(minutes<30) {
					int a = fir;
					total_money = a*sec;
				}else if(30<=minutes && minutes<180){
					int b = (int) Math.ceil((minutes-30)/60);
					total_money = 3*sec+b*thr;		
					
				}else if(180<=minutes && minutes<300) {
					int b = (int) Math.ceil((minutes-180)/60);
					total_money = 3*sec+b*thr;
				}
				
				else if(300<=minutes && minutes<480){
					
					int d = (int) Math.ceil((minutes-300)/60);	
					total_money = 3*sec+2*thr+fur*d;
				}else {
					int e = (int) Math.ceil((minutes-480)/(60*24));
					total_money = 3*sec+2*thr+fur*3+fiv*e;					
				}
			}
			String time = minutes/60+"小时 "+minutes%60+"分钟";
			CarOutMsg carout = new CarOutMsg();
			carout.setCar_license(carPark.getCar_park_license());
			carout.setCar_type(car_type);
			carout.setCharge_money(String.valueOf(total_money));
			carout.setIn_time(start_time);
			carout.setOut_time(now_time);
			carout.setStop_time(time);
			System.out.println("车牌号:"+carPark.getCar_park_license());
			System.out.println("收费金额："+total_money);
			System.out.println("出场时间："+now_time);
			System.out.println("车辆进场时间:"+start_time);
			System.out.println("汽车类型:" +car_type);
			System.out.println("停车时间:"+time);
			msgjson=	new Gson().toJson(carout);
			
		
    	}
		return msgjson;
		
	}
	
}
