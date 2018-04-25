package org.gzhz.otherManage.web;
/** 
* @author: 詹良斌
* @date 创建时间 2018年4月14日 上午1:00:27
* @Project: CarParkSystem
* @version V1.0 
* @parameter  *正式*针对用户表建立的用户类
* @since  
* @return
* @Description: TODO
*/

import java.util.List;

import javax.annotation.Resource;

import org.gzhz.otherManage.bean.CarVipTb;
import org.gzhz.otherManage.bean.ChargeRuleTb;
import org.gzhz.otherManage.bean.LogTb;
import org.gzhz.otherManage.dao.ChargeRule1Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;

@Controller
@RequestMapping("/chargerule")
public class ChargeRuleHandler {
	@Resource
	private ChargeRule1Mapper chargerulemapper;

	// 增加车牌
	@RequestMapping(value = "/addrule", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String addvipcar(ChargeRuleTb ruleTb) {
		ruleTb.setCharge_status("禁用");
		System.out.println(ruleTb);
		try {
			chargerulemapper.addChargeRule(ruleTb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String ruletb = gson.toJson(ruleTb);
		return ruletb;
	}

	// 查询计费规则
	@RequestMapping(value = "/searchchargerule", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String searchchargerule(int pageNum, int pageSize) {
		System.out.println(pageNum+"  "+pageSize);
		PageHelper.startPage(pageNum, pageSize);
		
	
		List<ChargeRuleTb> chargeRuleTbs = chargerulemapper.findChargerulemeal();
		PageInfo<ChargeRuleTb> pageInfo = new PageInfo<ChargeRuleTb>(chargeRuleTbs);
		Gson gson = new Gson();
		String chargerulegson = gson.toJson(pageInfo);

		return chargerulegson;
	}

	// 计费状态启用
	@RequestMapping(value = "/initiatemodechargerule", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String initiatemodechargerule(ChargeRuleTb ruleTb) {
		System.out.println(ruleTb);
		if (ruleTb.getCharge_status().equals("禁用")) {
			ruleTb.setCharge_status("启用");
			List<ChargeRuleTb> chargeRuleTbs = chargerulemapper.findMinitabByStatus("启用");
	     if(chargeRuleTbs.size()>0) {
	    	 
	    	 System.out.println(chargeRuleTbs.get(0));
	    	 chargeRuleTbs.get(0).setCharge_status("禁用");
	    	 chargerulemapper.changerulestues(chargeRuleTbs.get(0));
	     }
		} else if (ruleTb.getCharge_status().equals("启用")) {
			ruleTb.setCharge_status("禁用");
		}
		System.out.println(ruleTb);
		chargerulemapper.changerulestues(ruleTb);

		return null;
	}
	//改变规则
	@RequestMapping(value = "/changerule", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String changerule(ChargeRuleTb ruleTb) {
		System.out.println(ruleTb);
		chargerulemapper.changerulecost(ruleTb);
		
		return null;
	}
	//删除某个规则
	@RequestMapping(value = "/deletechargerule", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String deletechargerule(ChargeRuleTb ruleTb) {
		System.out.println(ruleTb);
		chargerulemapper.deletechargeRuleById(ruleTb);
		
		return null;
	}
	
	
	//页面跳转
	////http://localhost:8080/CarParkSystem/chargerule/pageTochargerule.action
		@RequestMapping("/pageTochargerule")
		public ModelAndView carviptourl() {
			ModelAndView modelAndView= new ModelAndView("zlbjsp/charge_rule");
			return modelAndView;
		}

}
