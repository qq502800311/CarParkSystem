package org.gzhz.otherManage.web;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.gzhz.otherManage.bean.LogTb;
import org.gzhz.otherManage.bean.MealTb;
import org.gzhz.otherManage.dao.PayMonthMapper;
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
 * @date 创建时间 2018年4月15日 下午8:58:16
 * @Project: CarParkSystem23
 * @version V1.0
 * @parameter *正式*针对用户表建立的用户类
 * @since
 * @return
 * @Description: TODO
 */
@Controller
@RequestMapping("/paymonth")
public class PayMonthHandler {
	@Resource
	private PayMonthMapper paymonthmapper;

	@RequestMapping(value = "/updatepaymoth", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String addpaymoth(

			@RequestParam(value = "meal_id1", required = true) String meal_id1,
			@RequestParam(value = "meal_id2", required = true) String meal_id2,
			@RequestParam(value = "meal_id3", required = true) String meal_id3,
			@RequestParam(value = "meal_money1", required = true) String meal_money1,
			@RequestParam(value = "meal_money2", required = true) String meal_money2,
			@RequestParam(value = "meal_money3", required = true) String meal_money3) {
		System.out.println("----------");
		System.out.println("meal_id1=" + meal_id1 + "   meal_id2=" + meal_id2 + "  meal_id3=" + meal_id3
				+ "  meal_money1=" + meal_money1 + "  meal_money2=" + meal_money2 + "  meal_money3=" + meal_money3);
		HashMap<String, String> hashMap1 = new HashMap<String, String>();
		hashMap1.put("meal_id", meal_id1);
		hashMap1.put("meal_money", meal_money1);
		paymonthmapper.updatemoney(hashMap1);
		HashMap<String, String> hashMap2 = new HashMap<String, String>();
		hashMap2.put("meal_id", meal_id2);
		hashMap2.put("meal_money", meal_money2);
		paymonthmapper.updatemoney(hashMap2);
		HashMap<String, String> hashMap3 = new HashMap<String, String>();
		hashMap3.put("meal_id", meal_id3);
		hashMap3.put("meal_money", meal_money3);
		paymonthmapper.updatemoney(hashMap3);

		return null;
	}

	// 套餐查询
	@RequestMapping(value = "/searchpay", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String searchpay(HttpServletRequest request, int pageNum, int pageSize) {
		System.out.println("----------");
		PageHelper.startPage(pageNum, pageSize);
		
	
		List<MealTb> list = paymonthmapper.findpaymonth();
		PageInfo<MealTb> pageInfo = new PageInfo<MealTb>(list);
		System.out.println("--" + list);
		String listjson = new Gson().toJson(pageInfo);

		return listjson;
	}

	// 修改状态
	@RequestMapping(value = "/changestatus", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String changestatus(HttpServletRequest request, String meal_status, String meal_pid) {
		System.out.println("----------" + meal_status + "--" + meal_pid);
		HashMap<String, String> hashMapchange = new HashMap<String, String>();
		String status = "";
		if (meal_status.equals("启用")) {
			status = "禁用";
		} else {
			status = "启用";
			// 先把原来启用的 变成禁用 查一遍数据库
			List<MealTb> qiyonglist = paymonthmapper.selectstatus(status);
			if (qiyonglist.size() > 0) {
				HashMap<String, String> hashMapstatus_pid_qiyong = new HashMap<String, String>();
				// 查询到当前的启用的PID
				String li = String.valueOf(qiyonglist.get(0).getMeal_pid());

				hashMapstatus_pid_qiyong.put("meal_status", "禁用");
				hashMapstatus_pid_qiyong.put("meal_pid", li);
				paymonthmapper.updatestatus(hashMapstatus_pid_qiyong);
				System.out.println("把启用 变成禁用");
			}
		}
		hashMapchange.put("meal_status", status);
		hashMapchange.put("meal_pid", meal_pid);
		paymonthmapper.updatestatus(hashMapchange);

		return null;
	}

	// 套餐删除
	@RequestMapping(value = "/deletemealtb", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String deletemealtb(String mealid) {

		paymonthmapper.deletemealtbById(mealid);
		return null;
	}

	// 增加
	@RequestMapping(value = "/addpaymoth", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String updatepaymoth(
			@RequestParam(value = "mealmoney_1", required = true, defaultValue = "empty") String mealmoney_1,
			@RequestParam(value = "mealmoney_2", required = true, defaultValue = "empty") String mealmoney_2,
			@RequestParam(value = "mealmoney_3", required = true, defaultValue = "empty") String mealmoney_3) {
		System.out.println("----------");
		System.out.println(
				"mealmoney_1=" + mealmoney_1 + "   mealmoney_2=" + mealmoney_2 + "  mealmoney_3=" + mealmoney_3);
		
		String pid=UUID.randomUUID().toString();
		String mealmoney[] = new String[] { mealmoney_1, mealmoney_2, mealmoney_3 };
		List<MealTb> mealTbs = new ArrayList<MealTb>();
		for (int i = 0; i < mealmoney.length; i++) {
			MealTb mealTb = new MealTb();
			mealTb.setMeal_money(Integer.parseInt(mealmoney[i]));
			if (i == 0) {
				mealTb.setMeal_name("月套餐");
				mealTb.setMeal_detail("包 1 个月：" + mealmoney[i] + "元/辆");
			}
			if (i == 1) {
				mealTb.setMeal_name("季套餐");
				mealTb.setMeal_detail("包 3 个月：" + mealmoney[i] + "元/辆");

			}
			if (i == 2) {
				mealTb.setMeal_name("半年套餐");
				mealTb.setMeal_detail("包 6 个月：" + mealmoney[i] + "元/辆");

			}
			mealTb.setMeal_status("禁用");
			mealTb.setMeal_pid(pid);
			mealTbs.add(mealTb);
		}
		try {
			paymonthmapper.insertWithList(mealTbs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public PayMonthMapper getPaymonthmapper() {
		return paymonthmapper;
	}

	public void setPaymonthmapper(PayMonthMapper paymonthmapper) {
		this.paymonthmapper = paymonthmapper;
	}
	//页面跳转
	//http://localhost:8080/CarParkSystem/paymonth/pageTopaymonth.action
	@RequestMapping("/pageTopaymonth")
	public ModelAndView pageTopaymonth() {
		ModelAndView modelAndView= new ModelAndView("zlbjsp/pay_monthly_management");
		return modelAndView;
	}

}
