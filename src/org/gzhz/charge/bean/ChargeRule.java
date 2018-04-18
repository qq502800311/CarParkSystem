package org.gzhz.charge.bean;
 /** 
* @author  作者 E-mail: 黄彪华
* @date 创建时间：2018年4月18日 上午9:22:36
* @version 1.03
* @parameter  
* @since  
* @return  
*/
public class ChargeRule {
	private int CHARGE_ID;
	private int charge_rule_1;
	private int charge_rule_2;
	private int charge_rule_3;
	private int charge_rule_4;
	private int charge_rule_5;
	private String charge_status;
	public ChargeRule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChargeRule(int cHARGE_ID, int charge_rule_1, int charge_rule_2, int charge_rule_3, int charge_rule_4,
			int charge_rule_5, String charge_status) {
		super();
		CHARGE_ID = cHARGE_ID;
		this.charge_rule_1 = charge_rule_1;
		this.charge_rule_2 = charge_rule_2;
		this.charge_rule_3 = charge_rule_3;
		this.charge_rule_4 = charge_rule_4;
		this.charge_rule_5 = charge_rule_5;
		this.charge_status = charge_status;
	}
	public int getCHARGE_ID() {
		return CHARGE_ID;
	}
	public void setCHARGE_ID(int cHARGE_ID) {
		CHARGE_ID = cHARGE_ID;
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
	public String getCharge_status() {
		return charge_status;
	}
	public void setCharge_status(String charge_status) {
		this.charge_status = charge_status;
	}
	
	
	
}
