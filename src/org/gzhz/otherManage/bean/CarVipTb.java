package org.gzhz.otherManage.bean;

import org.springframework.stereotype.Component;

/**
 * @author: 詹良斌
 * @date 创建时间 2018年4月12日 上午11:06:10
 * @Project: CarParkSystem
 * @version V1.0
 * @parameter *正式*针对用户表建立的用户类
 * @since
 * @return
 * @Description: TODO
 */
@Component
public class CarVipTb {
	private int vip_id;
	private String car_park_license;
	private int car_park_type;
	
	private Parameter_Tb parameter_tb;

	public int getVip_id() {
		return vip_id;
	}

	public void setVip_id(int vip_id) {
		this.vip_id = vip_id;
	}

	public String getCar_park_license() {
		return car_park_license;
	}

	public void setCar_park_license(String car_park_license) {
		this.car_park_license = car_park_license;
	}

	public int getCar_park_type() {
		return car_park_type;
	}

	public void setCar_park_type(int car_park_type) {
		this.car_park_type = car_park_type;
	}

	public CarVipTb() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	



	@Override
	public String toString() {
		return "CarVipTb [vip_id=" + vip_id + ", car_park_license=" + car_park_license + ", car_park_type="
				+ car_park_type + ", parameter_tb=" + parameter_tb + "]";
	}

	public Parameter_Tb getParameter_tb() {
		return parameter_tb;
	}

	public void setParameter_tb(Parameter_Tb parameter_tb) {
		this.parameter_tb = parameter_tb;
	}

}
