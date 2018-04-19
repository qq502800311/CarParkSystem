package org.gzhz.charge.bean;
 /** 
* @author  作者 E-mail: 黄彪华
* @date 创建时间：2018年4月18日 下午9:13:39
* @version 1.03
* @parameter  
* @since  
* @return  车辆出场信息
*/
public class CarOutMsg {
	
	private String car_license;
	private String charge_money;
	private String car_type;
	private String stop_time;    //停车时间
	private String in_time;
	private String out_time;
	public CarOutMsg() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarOutMsg(String car_license, String charge_money, String car_type, String stop_time, String in_time,
			String out_time) {
		super();
		this.car_license = car_license;
		this.charge_money = charge_money;
		this.car_type = car_type;
		this.stop_time = stop_time;
		this.in_time = in_time;
		this.out_time = out_time;
	}
	public String getCar_license() {
		return car_license;
	}
	public void setCar_license(String car_license) {
		this.car_license = car_license;
	}
	public String getCharge_money() {
		return charge_money;
	}
	public void setCharge_money(String charge_money) {
		this.charge_money = charge_money;
	}
	public String getCar_type() {
		return car_type;
	}
	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}
	public String getStop_time() {
		return stop_time;
	}
	public void setStop_time(String stop_time) {
		this.stop_time = stop_time;
	}
	public String getIn_time() {
		return in_time;
	}
	public void setIn_time(String in_time) {
		this.in_time = in_time;
	}
	public String getOut_time() {
		return out_time;
	}
	public void setOut_time(String out_time) {
		this.out_time = out_time;
	}
}
