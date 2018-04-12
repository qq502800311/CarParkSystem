package org.gzhz.charge.bean;

import org.springframework.stereotype.Component;

/** 
* @author  作者 E-mail: 黄彪华
* @date 创建时间：2018年4月12日 下午4:04:09
* @version 1.03
* @parameter  
* @since  
* @return  
*/

@Component
public class Meal {
	private int meal_id;
	private int meal_money;
	private String meal_name;
	private String meal_status;
	private String meal_detail;
	public Meal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Meal(int meal_id, int meal_money, String meal_name, String meal_status, String meal_detail) {
		super();
		this.meal_id = meal_id;
		this.meal_money = meal_money;
		this.meal_name = meal_name;
		this.meal_status = meal_status;
		this.meal_detail = meal_detail;
	}
	public int getMeal_id() {
		return meal_id;
	}
	public void setMeal_id(int meal_id) {
		this.meal_id = meal_id;
	}
	public int getMeal_money() {
		return meal_money;
	}
	public void setMeal_money(int meal_money) {
		this.meal_money = meal_money;
	}
	public String getMeal_name() {
		return meal_name;
	}
	public void setMeal_name(String meal_name) {
		this.meal_name = meal_name;
	}
	public String getMeal_status() {
		return meal_status;
	}
	public void setMeal_status(String meal_status) {
		this.meal_status = meal_status;
	}
	public String getMeal_detail() {
		return meal_detail;
	}
	public void setMeal_detail(String meal_detail) {
		this.meal_detail = meal_detail;
	}
}
