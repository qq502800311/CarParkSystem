package org.gzhz.otherManage.web;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.gzhz.manage.bean.Emp;
import org.gzhz.otherManage.bean.LogTb;
import org.gzhz.otherManage.bean.MoneyDetailTb;
import org.gzhz.otherManage.bean.ScheduleTb;
import org.gzhz.otherManage.dao.CrewSchedulingMapper;
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
@RequestMapping("/calendar")
public class CalendarHandler {

	@Resource
	public CrewSchedulingMapper crewschedulingmapper;
	 //添加员工左边list
	@RequestMapping(value = "/searchemplist", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String searchemplist() {
		List<Emp> emps = crewschedulingmapper.selectemplist();
		String empsjson = new Gson().toJson(emps);

		return empsjson;
	}
   //添加排班
	@RequestMapping(value = "/addWork", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String addWork(String emp_id, String sc_class, String date) {
		System.out.println("============addwork==========");
		System.out.println(emp_id + "," + sc_class + "," + date);
		Long time = Long.valueOf(date);
		Timestamp timestamp = new Timestamp(time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String S_TIME = sdf.format(timestamp);
		System.out.println("=======time=======" + S_TIME);
		ScheduleTb scheduleTb=new ScheduleTb();
		scheduleTb.setEmp_id(emp_id);
		scheduleTb.setSchedule_date(S_TIME);
		scheduleTb.setSchedule_shift(sc_class);
		List<ScheduleTb> scheduleTblist=crewschedulingmapper.selectexistbean(scheduleTb);
		String mString = null;
		if(scheduleTblist.size()>0) {
			mString="该班次已排过";
		}else {
		
		crewschedulingmapper.insertscheduleTb(scheduleTb);
		 mString = "排班成功";
		}
		String mgsjson = new Gson().toJson(mString);
		return mgsjson;
	}

	// 查询排班
	@RequestMapping(value = "/querycalendar", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String querycalendar() {
		System.out.println("============querycalendar==========");

		List<ScheduleTb> scheduleTbs = crewschedulingmapper.selectscheduletblist();
		System.out.println(scheduleTbs);
		String scheduleTbsgson = new Gson().toJson(scheduleTbs);

		return scheduleTbsgson;
	}

	// DELETE排班
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String delete(String scid) {
		System.out.println("============delete==========");

		crewschedulingmapper.deleteschedubletbById(scid);
		String mString = "删除成功";
		String msgjson = new Gson().toJson(mString);

		return msgjson;
	}

	// 跳转页面
	// http://localhost:8080/CarParkSystem/systemlog/pageTosystlog.action
	@RequestMapping("/pageTocalen")
	public ModelAndView carviptourl(HttpServletRequest request) {
		List<Emp> emps = crewschedulingmapper.selectemplist();
		request.setAttribute("emplist", emps);
		ModelAndView modelAndView = new ModelAndView("zlbjsp/calen");

		return modelAndView;
	}

	public CrewSchedulingMapper getCrewschedulingmapper() {
		return crewschedulingmapper;
	}

	public void setCrewschedulingmapper(CrewSchedulingMapper crewschedulingmapper) {
		this.crewschedulingmapper = crewschedulingmapper;
	}

}
