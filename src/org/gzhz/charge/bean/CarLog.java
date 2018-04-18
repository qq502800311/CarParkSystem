package org.gzhz.charge.bean;

import org.springframework.stereotype.Component;

/** 
* @author  作者 E-mail: 黄彪华
* @date 创建时间：2018年4月17日 上午9:35:10
* @version 1.03
* @parameter  
* @since  
* @return  
*/
@Component
public class CarLog {
	
	private int car_log_id;
	private String car_park_license;
	private String car_in_time;
	private String car_out_time;
	private int carport_id;        //车位id
	private int car_park_type;     //车辆类型
	private String emp_id;         //员工id
	private int car_money;      //收费金额
	private String picture_url;    //图片地址
	
	private Parameter parameter;
	public CarLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarLog(int car_log_id, String car_park_license, String car_in_time, String car_out_time, int carport_id,
			int car_park_type, String emp_id, int car_money, String picture_url) {
		super();
		this.car_log_id = car_log_id;
		this.car_park_license = car_park_license;
		this.car_in_time = car_in_time;
		this.car_out_time = car_out_time;
		this.carport_id = carport_id;
		this.car_park_type = car_park_type;
		this.emp_id = emp_id;
		this.car_money = car_money;
		this.picture_url = picture_url;
	}
	public int getCar_log_id() {
		return car_log_id;
	}
	public void setCar_log_id(int car_log_id) {
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
	public int getCarport_id() {
		return carport_id;
	}
	public void setCarport_id(int carport_id) {
		this.carport_id = carport_id;
	}
	public int getCar_park_type() {
		return car_park_type;
	}
	public void setCar_park_type(int car_park_type) {
		this.car_park_type = car_park_type;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public int getCar_money() {
		return car_money;
	}
	public void setCar_money(int car_money) {
		this.car_money = car_money;
	}
	public String getPicture_url() {
		return picture_url;
	}
	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}
	public Parameter getParameter() {
		return parameter;
	}
	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}
}
