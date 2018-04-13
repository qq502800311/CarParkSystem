/**
 * 
 */
package org.gzhz.manage.bean;

import org.springframework.stereotype.Component;

/** 
* @author  作者 E-mail: 郑伟豪
* @date 创建时间：2018年4月12日 上午8:21:09 
* @version 1.0 
* @parameter  *正式*针对用户表建立的后台管理菜单类
* @since  
* @return  
*/
@Component
public class MenuView {
	private String emp_id;
	private String first_menu_name;
	private String second_menu_name;
	private String menu_url;
	
	public MenuView() {
		super();
	}

	public MenuView(String emp_id, String first_menu_name, String second_menu_name, String menu_url) {
		super();
		this.emp_id = emp_id;
		this.first_menu_name = first_menu_name;
		this.second_menu_name = second_menu_name;
		this.menu_url = menu_url;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getFirst_menu_name() {
		return first_menu_name;
	}

	public void setFirst_menu_name(String first_menu_name) {
		this.first_menu_name = first_menu_name;
	}

	public String getSecond_menu_name() {
		return second_menu_name;
	}

	public void setSecond_menu_name(String second_menu_name) {
		this.second_menu_name = second_menu_name;
	}

	public String getMenu_url() {
		return menu_url;
	}

	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}

}
