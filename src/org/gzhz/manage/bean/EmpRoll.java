package org.gzhz.manage.bean;

import org.springframework.stereotype.Component;

/** 
* @author  作者 E-mail: 郑伟豪
* @date 创建时间：2018年4月12日 上午8:21:09 
* @version 1.0 
* @parameter  *正式*针对用户表建立的用户角色关系类
* @since  
* @return  
*/
@Component
public class EmpRoll {
	private int emp_role_id;
	private String emp_id;
	private int role_id;
	
	public EmpRoll() {
		super();
	}

	public EmpRoll(int emp_role_id, String emp_id, int role_id) {
		super();
		this.emp_role_id = emp_role_id;
		this.emp_id = emp_id;
		this.role_id = role_id;
	}

	public int getEmp_role_id() {
		return emp_role_id;
	}

	public void setEmp_role_id(int emp_role_id) {
		this.emp_role_id = emp_role_id;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
	
}
