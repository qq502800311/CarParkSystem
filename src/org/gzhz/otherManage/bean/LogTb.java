package org.gzhz.otherManage.bean;

import org.springframework.stereotype.Component;

/**
 * @author: 詹良斌
 * @date 创建时间 2018年4月18日 下午3:32:18
 * @Project: CarParkSystem23
 * @version V1.0
 * @parameter *正式*针对用户表建立的用户类
 * @since
 * @return
 * @Description: TODO
 */
@Component
public class LogTb {
	private int log_id;
	private String emp_id;
	private String log_even;
	private String log_time;

	private EmpTb emptb;

	@Override
	public String toString() {
		return "LogTb [log_id=" + log_id + ", emp_id=" + emp_id + ", log_even=" + log_even + ", log_time=" + log_time
				+ "]";
	}

	public LogTb(int log_id, String emp_id, String log_even, String log_time) {
		super();
		this.log_id = log_id;
		this.emp_id = emp_id;
		this.log_even = log_even;
		this.log_time = log_time;
	}

	public LogTb() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getLog_id() {
		return log_id;
	}

	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getLog_even() {
		return log_even;
	}

	public void setLog_even(String log_even) {
		this.log_even = log_even;
	}

	public String getLog_time() {
		return log_time;
	}

	public void setLog_time(String log_time) {
		this.log_time = log_time;
	}

	public EmpTb getEmptb() {
		return emptb;
	}

	public void setEmptb(EmpTb emptb) {
		this.emptb = emptb;
	}

}
