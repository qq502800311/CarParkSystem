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
	private String menu_url;
	
	private String second_menu_name;
	
	public Menu() {
		super();
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

	public String getMenu_url() {
		return menu_url;
	}

	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}

	public String getSecond_menu_name() {
		return second_menu_name;
	}

	public void setSecond_menu_name(String second_menu_name) {
		this.second_menu_name = second_menu_name;
	}
	
}
