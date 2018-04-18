package org.gzhz.charge.bean;
 /** 
* @author  作者 E-mail: 黄彪华
* @date 创建时间：2018年4月13日 下午3:06:05
* @version 1.03
* @parameter  
* @since  
* @return  
*/
public class MonthUser {
	
	private String user_id;
	private String car_park_license;
    private String user_register_date;
    private String user_timeout_date;
    private String user_name;
    private String user_pwd;
    private String user_phone;
    private int meal_id;
    private String user_status;
    private Meal meal;
    
	public MonthUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MonthUser(String user_id, String car_park_license, String user_register_date, String user_timeout_date,
			String user_name, String user_pwd, String user_phone, int meal_id, String user_status) {
		super();
		this.user_id = user_id;
		this.car_park_license = car_park_license;
		this.user_register_date = user_register_date;
		this.user_timeout_date = user_timeout_date;
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.user_phone = user_phone;
		this.meal_id = meal_id;
		this.user_status = user_status;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCar_park_license() {
		return car_park_license;
	}
	public void setCar_park_license(String car_park_license) {
		this.car_park_license = car_park_license;
	}
	public String getUser_register_date() {
		return user_register_date;
	}
	public void setUser_register_date(String user_register_date) {
		this.user_register_date = user_register_date;
	}
	public String getUser_timeout_date() {
		return user_timeout_date;
	}
	public void setUser_timeout_date(String user_timeout_date) {
		this.user_timeout_date = user_timeout_date;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public int getMeal_id() {
		return meal_id;
	}
	public void setMeal_id(int meal_id) {
		this.meal_id = meal_id;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	public Meal getMeal() {
		return meal;
	}
	public void setMeal(Meal meal) {
		this.meal = meal;
	}
}
