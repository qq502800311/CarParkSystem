package org.gzhz.park.bean;
/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年4月13日 下午4:19:00 
* @version 1.0 
* @description 停车场日志表类
*/

public class CarLog {
	
	private Integer car_log_id;			//日志表ID
	private String 	car_park_license;	//车辆车牌
	private String 	car_in_time;		//车辆进入时间
	private String 	car_out_time;		//车辆离开时间
	private Integer carport_id;			//车辆停放的车位ID
	private Integer car_park_type;		//车辆类型ID
	private String 	emp_id;				//收费员工ID
	private Integer car_money;			//消费金额
	private String 	picture_url;		//车牌图片地址
	
	public CarLog() {
		super();
	}

	public Integer getCar_log_id() {
		return car_log_id;
	}

	public void setCar_log_id(Integer car_log_id) {
		this.car_log_id = car_log_id;
	}

	public String getCar_park_license() {
		return car_park_license;
	}

	public void setCar_park_license(String car_park_license) {
		this.car_park_license = car_park_license;
	}

	public String getCar_in_time() {
		return car_in_time;
	}

	public void setCar_in_time(String car_in_time) {
		this.car_in_time = car_in_time;
	}

	public String getCar_out_time() {
		return car_out_time;
	}

	public void setCar_out_time(String car_out_time) {
		this.car_out_time = car_out_time;
	}

	public Integer getCarport_id() {
		return carport_id;
	}

	public void setCarport_id(Integer carport_id) {
		this.carport_id = carport_id;
	}

	public Integer getCar_park_type() {
		return car_park_type;
	}

	public void setCar_park_type(Integer car_park_type) {
		this.car_park_type = car_park_type;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public Integer getCar_money() {
		return car_money;
	}

	public void setCar_money(Integer car_money) {
		this.car_money = car_money;
	}

	public String getPicture_url() {
		return picture_url;
	}

	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}
	
	
	
}
