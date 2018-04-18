package org.gzhz.otherManage.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	// 查询车牌
	@RequestMapping(value = "/vipsearch", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String vipcarinfo(HttpServletRequest request, String car_park_license) {
		// String car_park_license 前端发来数据
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
}
