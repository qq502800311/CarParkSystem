package org.gzhz.otherManage.web;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.gzhz.otherManage.bean.CarportTb;
import org.gzhz.otherManage.bean.MealTb;
import org.gzhz.otherManage.dao.CarPortMapper;
import org.gzhz.otherManage.dao.PayMonthMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author: 詹良斌
 * @date 创建时间 2018年4月15日 下午8:58:16
 * @Project: CarParkSystem23
 * @version V1.0
 * @parameter *正式*针对用户表建立的用户类
 * @since
 * @return
 * @Description: TODO
 */
@Controller
@RequestMapping("/carport")
public class CarPortHandler {
	@Resource
	private CarPortMapper carportmapper;

	// 套餐查询
	@RequestMapping(value = "/searchcarport", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String searchpay(HttpServletRequest request, String carport_num, String carport_status) {
		System.out.println(carport_status + "----------" + carport_num);
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("carport_num", "%" + carport_num + "%");
		hashMap.put("carport_status", carport_status);
		List<CarportTb> carportTbs = carportmapper.findCarportByName(hashMap);
		System.out.println("" + carportTbs);

		String listjson = new Gson().toJson(carportTbs);

		return listjson;
	}

	// 状态修改
	@RequestMapping(value = "/changestatus", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String changestatus(HttpServletRequest request,
			@RequestParam(value = "carport_status", required = true, defaultValue = "empty") String carport_status,
			String carport_id) {
		System.out.println(carport_status + "-----状态修改-----" + carport_id);
		CarportTb carportTb = new CarportTb();
		if (carport_status.equals("8")) {
			carportTb.setCarport_status(7);

		} else {
			carportTb.setCarport_status(8);
		}

		carportTb.setCarport_id(Integer.parseInt(carport_id));
		carportmapper.updatcarportstatus(carportTb);
		return null;
	}

	// 车位增加
	@RequestMapping(value = "/addcarport", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String addcarport(HttpServletRequest request, String carport_area, String carport_num1,
			String carport_num2) {
		System.out.println(carport_area + "----------" + carport_num1 + "----------" + carport_num2);
		HashMap<String, String> hashMap = new HashMap<String, String>();
		DecimalFormat dFormat = new DecimalFormat("000");
		int starnum = Integer.parseInt(carport_num1);
		int endnum = Integer.parseInt(carport_num2);
		String nowcarport_num1 = dFormat.format(starnum);
		String nowcarport_num2 = dFormat.format(endnum);
		System.out.println(nowcarport_num1);
		List<CarportTb> carportTbs = new ArrayList<CarportTb>();
		for (int i = starnum; i < endnum + 1; i++) {
			CarportTb tb = new CarportTb();
			tb.setCarport_num(carport_area + dFormat.format(i));
			tb.setCarport_area(carport_area);
			tb.setCarport_status(7);
			// 测试照片地址
			tb.setPicture_url("测试照片地址");
			carportTbs.add(tb);
		}
		try {
			carportmapper.insertcarport(carportTbs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String carportmessage = "上传成功";
		Gson gson = new Gson();
		String carportmessagejson = gson.toJson(carportmessage);
		return carportmessagejson;
	}

	public CarPortMapper getCarportmapper() {
		return carportmapper;
	}

	public void setCarportmapper(CarPortMapper carportmapper) {
		this.carportmapper = carportmapper;
	}

	// 页面跳转
	// http://localhost:8080/CarParkSystem/carport/pageTocarport.action
	@RequestMapping("/pageTocarport")
	public ModelAndView pageTocarport() {
		ModelAndView modelAndView = new ModelAndView("zlbjsp/carport_configuration");
		return modelAndView;
	}
}
