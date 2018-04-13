package org.gzhz.manage.bean;

import org.springframework.stereotype.Component;

/** 
* @author  作者 E-mail: 郑伟豪
* @date 创建时间：2018年4月12日 上午8:21:09 
* @version 1.0 
* @parameter  *正式*针对用户表建立的角色类
* @since  
* @return  
*/
@Component
public class Role {
	private int role_id;
	private String role_name;
	
	public Role() {
		super();
	}

	public Role(int role_id, String role_name) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	
}
