package org.gzhz.manage.bean;

import org.springframework.stereotype.Component;

/** 
* @author  作者 E-mail: 郑伟豪
* @date 创建时间：2018年4月12日 上午8:21:09 
* @version 1.0 
* @parameter  *正式*针对用户表建立的菜单类
* @since  
* @return  
*/
@Component
public class Menu {
	private int menu_id;
	private int menu_pid;
	private String menu_name;
	
	public Menu() {
		super();
	}

	public Menu(int menu_id, int menu_pid, String menu_name) {
		super();
		this.menu_id = menu_id;
		this.menu_pid = menu_pid;
		this.menu_name = menu_name;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public int getMenu_pid() {
		return menu_pid;
	}

	public void setMenu_pid(int menu_pid) {
		this.menu_pid = menu_pid;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	
	
}
