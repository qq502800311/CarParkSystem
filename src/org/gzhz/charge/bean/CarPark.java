package org.gzhz.charge.bean;

import org.springframework.stereotype.Component;

/** 
* @author  作者 E-mail: 黄彪华
* @date 创建时间：2018年4月15日 下午5:15:11
* @version 1.03
* @parameter  
* @since  
* @return  
*/
@Component
public class CarPark {
	private int car_park_id;
	private String car_park_license;
	private String car_in_time;
	private int car_park_type;
	private int carport_id;
	private String car_park_status;
	
	private Parameter parameter;
	public CarPark() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarPark(int car_park_id, String car_park_license, String car_in_time, int car_park_type, int carport_id,
			String car_park_status) {
		super();
		this.car_park_id = car_park_id;
		this.car_park_license = car_park_license;
		this.car_in_time = car_in_time;
		this.car_park_type = car_park_type;
		this.carport_id = carport_id;
		this.car_park_status = car_park_status;
	}
	public int getCar_park_id() {
		return car_park_id;
	}
	public void setCar_park_id(int car_park_id) {
		this.car_park_id = car_park_id;
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
	public int getCar_park_type() {
		return car_park_type;
	}
	public void setCar_park_type(int car_park_type) {
		this.car_park_type = car_park_type;
	}
	public int getCarport_id() {
		return carport_id;
	}
	public void setCarport_id(int carport_id) {
		this.carport_id = carport_id;
	}
	public String getCar_park_status() {
		return car_park_status;
	}
	public void setCar_park_status(String car_park_status) {
		this.car_park_status = car_park_status;
	}
	public Parameter getParameter() {
		return parameter;
	}
	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}
	

}
