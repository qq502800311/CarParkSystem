package org.gzhz.otherManage.web;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.gzhz.otherManage.bean.LogTb;
import org.gzhz.otherManage.bean.MoneyDetailTb;
import org.gzhz.otherManage.dao.ReciptPaymentMapper;
import org.gzhz.otherManage.dao.SystemLogMapper;
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
@RequestMapping("/systemlog")
public class SystemLogHandler {

	@Resource
	public SystemLogMapper systemlogmappermapper;

	@RequestMapping(value="/searchsyslog",  method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String searchmoneydetail(String endtime_systemlog, String starttime_systemlog, String emp_name) {
		System.out.println(
				"endtime_systemlog=" + endtime_systemlog + "starttime_systemlog" + starttime_systemlog);
		HashMap<String, String> hashMap = new HashMap<String, String>();
		String starttime=null;
		String endtime=null;
		if(starttime_systemlog==null||starttime_systemlog=="") {
			
		}else {
			starttime=	starttime_systemlog+" 00:00:00";
		}
		if(endtime_systemlog==null||endtime_systemlog=="") {
			
		}else {
			endtime=	endtime_systemlog+"  24:00:00";
		}
//		
		hashMap.put("starttime_systemlog", starttime);
		hashMap.put("endtime_systemlog", endtime);
		hashMap.put("emp_name", emp_name);
		List<LogTb> list=	systemlogmappermapper.selectlog(hashMap);
		System.out.println(list);
//		List<MoneyDetailTb> detailTbs = reciptpaymentmapper.selectsumlist(hashMap);
//		System.out.println(detailTbs);
		Gson gson=new Gson();
		String logselectjson=	gson.toJson(list);
		System.out.println("logselectjson"+logselectjson);
		return logselectjson;

	}
	
	//跳转页面
	//http://localhost:8080/CarParkSystem/systemlog/pageTosystlog.action
	@RequestMapping("/pageTosystlog")
	public ModelAndView carviptourl() {
		ModelAndView modelAndView= new ModelAndView("zlbjsp/systemlog");
		return modelAndView;
	}

	public SystemLogMapper getSystemlogmappermapper() {
		return systemlogmappermapper;
	}

	public void setSystemlogmappermapper(SystemLogMapper systemlogmappermapper) {
		this.systemlogmappermapper = systemlogmappermapper;
	}

	

}
