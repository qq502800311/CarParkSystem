package org.gzhz.manage.bean;

import org.springframework.stereotype.Component;

/** 
* @author  作者 E-mail: 郑伟豪
* @date 创建时间：2018年4月12日 上午8:21:09 
* @version 1.0 
* @parameter  *正式*针对用户表建立的角色菜单类
* @since  
* @return  
*/
@Component
public class RoleMenu {
	private int role_menu_id;
	private int role_id;
	private int menu_id;
	
	public RoleMenu() {
		super();
	}

	public RoleMenu(int role_menu_id, int role_id, int menu_id) {
		super();
		this.role_menu_id = role_menu_id;
		this.role_id = role_id;
		this.menu_id = menu_id;
	}

	public int getRole_menu_id() {
		return role_menu_id;
	}

	public void setRole_menu_id(int role_menu_id) {
		this.role_menu_id = role_menu_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	
	
}
