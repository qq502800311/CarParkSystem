package org.gzhz.otherManage.bean;

import org.springframework.stereotype.Component;

/**
 * @author: 詹良斌
 * @date 创建时间 2018年4月19日 上午1:27:24
 * @Project: CarParkSystem23
 * @version V1.0
 * @parameter *正式*针对用户表建立的用户类
 * @since
 * @return
 * @Description: TODO
 */
@Component
public class EmpTb {
	private String emp_id;
	private String emp_name;
	private String emp_pwd;
	private String emp_status;
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_pwd() {
		return emp_pwd;
	}
	public void setEmp_pwd(String emp_pwd) {
		this.emp_pwd = emp_pwd;
	}
	public String getEmp_status() {
		return emp_status;
	}
	public void setEmp_status(String emp_status) {
		this.emp_status = emp_status;
	}
	@Override
	public String toString() {
		return "EmpTb [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_pwd=" + emp_pwd + ", emp_status="
				+ emp_status + "]";
	}
	public EmpTb() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpTb(String emp_id, String emp_name, String emp_pwd, String emp_status) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_pwd = emp_pwd;
		this.emp_status = emp_status;
	}
	
	
}
