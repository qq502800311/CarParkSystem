package org.gzhz.park.bean;

import org.springframework.stereotype.Component;

/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年4月12日 上午10:30:45 
* @version 1.0 
* @description 停车场车辆信息类
*/
@Component
public class CarInfo {
	
	private Integer car_park_id;		//停车信息ID
	private String 	car_park_license;	//车辆牌照
	private String 	car_in_time;		//车辆进入时间
	private Integer car_park_type;		//车辆类型
	private Integer carport_id;			//车辆停放车位编号
	private String 	car_park_status;	//车辆缴费状态
	
	private CarPort carport; 			//车辆停放的车位类
	private CarType cartype; 			//车辆类型信息类
	
	
	public CarInfo() {
		super();
	}
	

	public CarInfo(String car_park_license, String car_in_time) {
		super();
		this.car_park_license = car_park_license;
		this.car_in_time = car_in_time;
	}



	public Integer getCar_park_id() {
		return car_park_id;
	}

	public void setCar_park_id(Integer car_park_id) {
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

	public Integer getCar_park_type() {
		return car_park_type;
	}

	public void setCar_park_type(Integer car_park_type) {
		this.car_park_type = car_park_type;
	}

	public Integer getCarport_id() {
		return carport_id;
	}

	public void setCarport_id(Integer carport_id) {
		this.carport_id = carport_id;
	}

	public String getCar_park_status() {
		return car_park_status;
	}

	public void setCar_park_status(String car_park_status) {
		this.car_park_status = car_park_status;
	}


	public CarPort getCarport() {
		return carport;
	}


	public void setCarport(CarPort carport) {
		this.carport = carport;
	}


	public CarType getCartype() {
		return cartype;
	}


	public void setCartype(CarType cartype) {
		this.cartype = cartype;
	}
	
	
}
