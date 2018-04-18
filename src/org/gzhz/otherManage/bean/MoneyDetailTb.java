package org.gzhz.otherManage.bean;

import org.springframework.stereotype.Component;

/**
 * @author: 詹良斌
 * @date 创建时间 2018年4月18日 下午2:07:36
 * @Project: CarParkSystem23
 * @version V1.0
 * @parameter *正式*针对用户表建立的用户类
 * @since
 * @return
 * @Description: TODO
 */
@Component
public class MoneyDetailTb {
	private int detail_id;
	private String car_park_license;
	private String deal_time;
	private String deal_matter;
	private int deal_money;
	private String deal_method;

	public MoneyDetailTb(int detail_id, String car_park_license, String deal_time, String deal_matter, int deal_money,
			String deal_method) {
		super();
		this.detail_id = detail_id;
		this.car_park_license = car_park_license;
		this.deal_time = deal_time;
		this.deal_matter = deal_matter;
		this.deal_money = deal_money;
		this.deal_method = deal_method;
	}

	public MoneyDetailTb() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MoneyDetailTb [detail_id=" + detail_id + ", car_park_license=" + car_park_license + ", deal_time="
				+ deal_time + ", deal_matter=" + deal_matter + ", deal_money=" + deal_money + ", deal_method="
				+ deal_method + "]";
	}

	public int getDetail_id() {
		return detail_id;
	}

	public void setDetail_id(int detail_id) {
		this.detail_id = detail_id;
	}

	public String getCar_park_license() {
		return car_park_license;
	}

	public void setCar_park_license(String car_park_license) {
		this.car_park_license = car_park_license;
	}

	public String getDeal_time() {
		return deal_time;
	}

	public void setDeal_time(String deal_time) {
		this.deal_time = deal_time;
	}

	public String getDeal_matter() {
		return deal_matter;
	}

	public void setDeal_matter(String deal_matter) {
		this.deal_matter = deal_matter;
	}

	public int getDeal_money() {
		return deal_money;
	}

	public void setDeal_money(int deal_money) {
		this.deal_money = deal_money;
	}

	public String getDeal_method() {
		return deal_method;
	}

	public void setDeal_method(String deal_method) {
		this.deal_method = deal_method;
	}

}
