package org.gzhz.otherManage.web;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.gzhz.otherManage.bean.CarVipTb;
import org.gzhz.otherManage.dao.CarVipMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "/vipsearch", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String vipcarinfo(String car_park_license) {
		// String car_park_license 前端发来数据
		//
		StringBuffer buffer = null;
		String carparklicense = null;
		if (!car_park_license.equals("") || car_park_license == null) {
			buffer = new StringBuffer("%");
			buffer.append(car_park_license);
			buffer.append("%");
			carparklicense = buffer.toString();
		}
		List<CarVipTb> carVipTbs = carvipmapper.findCarVipByName(carparklicense);
		System.out.println(carparklicense);
		System.out.println("vipcarinfo方法被调用了...");
		System.out.println(carVipTbs);
		Gson gson = new Gson();

		String documentstring = gson.toJson(carVipTbs);
		return documentstring;
	}
	
	@RequestMapping(value = "/vipcarmodifier", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String vipcarmodifier(String currentcarparklicense,
			String modifiercarparkchangeCarparklicense) {
		System.out.println(currentcarparklicense+"="+modifiercarparkchangeCarparklicense);
		HashMap<String , String> map=new HashMap<String , String>();
		map.put("currentcarparklicense", currentcarparklicense);
		map.put("modifiercarparkchangeCarparklicense", modifiercarparkchangeCarparklicense);
		carvipmapper.changevipcarbrand(map);
		
		return null; 
		
	}
	@RequestMapping(value = "/deletevipcar", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String deletevipcar(String currentcarparklicense) {
		carvipmapper.deletevip(currentcarparklicense);
		
//		carvipmapper;
		
		return null; 
		
	}
	@RequestMapping(value = "/addvipcar", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String addvipcar(String newvip_Name) {
		System.out.println(newvip_Name);
		
		carvipmapper.addvip(newvip_Name);;
		
		return null; 
		
	}
}
