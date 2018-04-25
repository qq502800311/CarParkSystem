package org.gzhz.otherManage.bean;

import org.springframework.stereotype.Component;

/**
 * @author: 詹良斌
 * @date 创建时间 2018年4月23日 下午3:36:24
 * @Project: CarParkSystem
 * @version V1.0
 * @parameter *正式*针对用户表建立的用户类
 * @since
 * @return
 * @Description: TODO
 */
@Component
public class ScheduleTb {
	private int schedule_id;
	private String schedule_date;
	private String schedule_shift;
	private String emp_id;
	
	private EmpTb empTb;
	
	public EmpTb getEmpTb() {
		return empTb;
	}
	public void setEmpTb(EmpTb empTb) {
		this.empTb = empTb;
	}
	public int getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}
	public String getSchedule_date() {
		return schedule_date;
	}
	public void setSchedule_date(String schedule_date) {
		this.schedule_date = schedule_date;
	}
	public String getSchedule_shift() {
		return schedule_shift;
	}
	public void setSchedule_shift(String schedule_shift) {
		this.schedule_shift = schedule_shift;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public ScheduleTb() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScheduleTb(int schedule_id, String schedule_date, String schedule_shift, String emp_id) {
		super();
		this.schedule_id = schedule_id;
		this.schedule_date = schedule_date;
		this.schedule_shift = schedule_shift;
		this.emp_id = emp_id;
	}
	@Override
	public String toString() {
		return "ScheduleTb [schedule_id=" + schedule_id + ", schedule_date=" + schedule_date + ", schedule_shift="
				+ schedule_shift + ", emp_id=" + emp_id + ", empTb=" + empTb + "]";
	}
	



      
}
