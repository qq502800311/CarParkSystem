package org.gzhz.otherManage.web;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.gzhz.otherManage.bean.MoneyDetailTb;
import org.gzhz.otherManage.dao.ReciptPaymentMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

/**
 * @author: 詹良斌
 * @date 创建时间 2018年4月18日 下午2:16:44
 * @Project: CarParkSystem23
 * @version V1.0
 * @parameter *正式*针对用户表建立的用户类
 * @since
 * @return
 * @Description: TODO
 */
@Controller
@RequestMapping("/reciptpay")
public class ReciptPaymentHandler {

	@Resource
	public ReciptPaymentMapper reciptpaymentmapper;

	@RequestMapping(value="/searchmoneydetail",  method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String searchmoneydetail(String endtime_moneydetail, String starttime_moneydetail) {
		System.out.println(
				"starttime_moneydetail=" + starttime_moneydetail + "endtime_moneydetail" + endtime_moneydetail);
		HashMap<String, String> hashMap = new HashMap<String, String>();
		String starttime=null;
		String endtime=null;
		if(starttime_moneydetail==null||starttime_moneydetail=="") {
			
		}else {
			starttime=	starttime_moneydetail+" 00:00:00";
		}
		if(endtime_moneydetail==null||endtime_moneydetail=="") {
			
		}else {
			endtime=	endtime_moneydetail+"  24:00:00";
		}
		
		hashMap.put("starttime_moneydetail", starttime);
		hashMap.put("endtime_moneydetail", endtime);
		List<MoneyDetailTb> detailTbs = reciptpaymentmapper.selectsumlist(hashMap);
		System.out.println(detailTbs);
		Gson gson=new Gson();
		String detailTbsjson=	gson.toJson(detailTbs);
		System.out.println("detailTbsjson"+detailTbsjson);
		return detailTbsjson;

	}
	
	
	@RequestMapping("/pageToreceiptpay")
	public ModelAndView carviptourl() {
		ModelAndView modelAndView= new ModelAndView("zlbjsp/receiptpayment");
		return modelAndView;
	}


	public ReciptPaymentMapper getReciptpaymentmapper() {
		return reciptpaymentmapper;
	}

	public void setReciptpaymentmapper(ReciptPaymentMapper reciptpaymentmapper) {
		this.reciptpaymentmapper = reciptpaymentmapper;
	}

}
