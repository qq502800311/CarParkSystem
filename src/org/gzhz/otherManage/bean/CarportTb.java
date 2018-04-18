package org.gzhz.otherManage.bean;

import org.springframework.stereotype.Component;

/**
 * @author: 詹良斌
 * @date 创建时间 2018年4月17日 下午2:51:46
 * @Project: CarParkSystem23
 * @version V1.0
 * @parameter *正式*针对用户表建立的用户类
 * @since
 * @return
 * @Description: TODO
 */
@Component
public class CarportTb {
	private int carport_id;
	private String carport_area;
	private String carport_num;
	private int carport_status;
	private String picture_url;
	
	private Parameter_Tb parameter_tb;

	public int getCarport_id() {
		return carport_id;
	}

	public void setCarport_id(int carport_id) {
		this.carport_id = carport_id;
	}

	public String getCarport_area() {
		return carport_area;
	}

	public void setCarport_area(String carport_area) {
		this.carport_area = carport_area;
	}

	public String getCarport_num() {
		return carport_num;
	}

	public void setCarport_num(String carport_num) {
		this.carport_num = carport_num;
	}

	public int getCarport_status() {
		return carport_status;
	}

	public void setCarport_status(int carport_status) {
		this.carport_status = carport_status;
	}

	public String getPicture_url() {
		return picture_url;
	}

	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}

	public Parameter_Tb getParameter_tb() {
		return parameter_tb;
	}

	public void setParameter_tb(Parameter_Tb parameter_tb) {
		this.parameter_tb = parameter_tb;
	}

	public CarportTb(int carport_id, String carport_area, String carport_num, int carport_status, String picture_url) {
		super();
		this.carport_id = carport_id;
		this.carport_area = carport_area;
		this.carport_num = carport_num;
		this.carport_status = carport_status;
		this.picture_url = picture_url;
	}

	public CarportTb() {
		super();
	}

	@Override
	public String toString() {
		return "CarportTb [carport_id=" + carport_id + ", carport_area=" + carport_area + ", carport_num=" + carport_num
				+ ", carport_status=" + carport_status + ", picture_url=" + picture_url + ", parameter_tb="
				+ parameter_tb + "]";
	}



}
