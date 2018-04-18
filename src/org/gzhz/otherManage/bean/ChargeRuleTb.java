package org.gzhz.otherManage.bean;

import org.springframework.stereotype.Component;

/**
 * @author: 詹良斌
 * @date 创建时间 2018年4月14日 上午1:01:47
 * @Project: CarParkSystem
 * @version V1.0
 * @parameter *正式*针对用户表建立的用户类
 * @since
 * @return
 * @Description: TODO
 */
@Component
public class ChargeRuleTb {
	private int charge_id;
	private int charge_rule_1;
	private int charge_rule_2;
	private int charge_rule_3;
	private int charge_rule_4;
	private int charge_rule_5;
    private String charge_status;
	public ChargeRuleTb(int charge_id, int charge_rule_1, int charge_rule_2, int charge_rule_3, int charge_rule_4,
			int charge_rule_5, String charge_status) {
		super();
		this.charge_id = charge_id;
		this.charge_rule_1 = charge_rule_1;
		this.charge_rule_2 = charge_rule_2;
		this.charge_rule_3 = charge_rule_3;
		this.charge_rule_4 = charge_rule_4;
		this.charge_rule_5 = charge_rule_5;
		this.charge_status = charge_status;
	}

	public String getCharge_status() {
		return charge_status;
	}

	public void setCharge_status(String charge_status) {
		this.charge_status = charge_status;
	}

	public int getCharge_id() {
		return charge_id;
	}

	public void setCharge_id(int charge_id) {
		this.charge_id = charge_id;
	}

	public int getCharge_rule_1() {
		return charge_rule_1;
	}

	public void setCharge_rule_1(int charge_rule_1) {
		this.charge_rule_1 = charge_rule_1;
	}

	public int getCharge_rule_2() {
		return charge_rule_2;
	}

	public void setCharge_rule_2(int charge_rule_2) {
		this.charge_rule_2 = charge_rule_2;
	}

	public int getCharge_rule_3() {
		return charge_rule_3;
	}

	public void setCharge_rule_3(int charge_rule_3) {
		this.charge_rule_3 = charge_rule_3;
	}

	public int getCharge_rule_4() {
		return charge_rule_4;
	}

	public void setCharge_rule_4(int charge_rule_4) {
		this.charge_rule_4 = charge_rule_4;
	}

	public int getCharge_rule_5() {
		return charge_rule_5;
	}

	public void setCharge_rule_5(int charge_rule_5) {
		this.charge_rule_5 = charge_rule_5;
	}

	public ChargeRuleTb(int charge_id, int charge_rule_1, int charge_rule_2, int charge_rule_3, int charge_rule_4,
			int charge_rule_5) {
		super();
		this.charge_id = charge_id;
		this.charge_rule_1 = charge_rule_1;
		this.charge_rule_2 = charge_rule_2;
		this.charge_rule_3 = charge_rule_3;
		this.charge_rule_4 = charge_rule_4;
		this.charge_rule_5 = charge_rule_5;
	}

	public ChargeRuleTb() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ChargeRuleTb [charge_id=" + charge_id + ", charge_rule_1=" + charge_rule_1 + ", charge_rule_2="
				+ charge_rule_2 + ", charge_rule_3=" + charge_rule_3 + ", charge_rule_4=" + charge_rule_4
				+ ", charge_rule_5=" + charge_rule_5 + ", charge_status=" + charge_status + "]";
	}

}
