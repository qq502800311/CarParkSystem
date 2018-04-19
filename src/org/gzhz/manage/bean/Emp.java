package org.gzhz.manage.bean;

import java.util.List;

import org.springframework.stereotype.Component;

/** 
* @author  作者 E-mail: 郑伟豪
* @date 创建时间：2018年4月12日 上午8:21:09 
* @version 1.0 
* @parameter  *正式*针对用户表建立的用户类
* @since  
* @return  
*/
@Component
public class Emp {
	private String emp_id;
	private String emp_name;
	private String emp_pwd;
	private String emp_status;
	
	//一对多
	private List<EmpRole> empRoleList;
	
	public Emp() {
		super();
	}
	
	public Emp(String emp_id, String emp_name, String emp_pwd, String emp_status) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_pwd = emp_pwd;
		this.emp_status = emp_status;
	}

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

	public List<EmpRole> getEmpRoleList() {
		return empRoleList;
	}

	public void setEmpRoleList(List<EmpRole> empRoleList) {
		this.empRoleList = empRoleList;
	}

	
	
	
}
