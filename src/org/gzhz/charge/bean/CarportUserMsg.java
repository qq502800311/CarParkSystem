package org.gzhz.charge.bean;

import org.springframework.stereotype.Component;

/** 
* @author  作者 E-mail: 黄彪华
* @date 创建时间：2018年4月12日 上午10:54:49 
* @version 1.03
* @parameter  
* @since  
* @return  
*/
@Component
public class CarportUserMsg {
	
	private int carport_using_num;
	private int carport_remain_num;
	private String welcome_word;
	public CarportUserMsg() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarportUserMsg(int carport_using_num, int carport_remain_num, String welcome_word) {
		super();
		this.carport_using_num = carport_using_num;
		this.carport_remain_num = carport_remain_num;
		this.welcome_word = welcome_word;
	}
	public int getCarport_using_num() {
		return carport_using_num;
	}
	public void setCarport_using_num(int carport_using_num) {
		this.carport_using_num = carport_using_num;
	}
	public int getCarport_remain_num() {
		return carport_remain_num;
	}
	public void setCarport_remain_num(int carport_remain_num) {
		this.carport_remain_num = carport_remain_num;
	}
	public String getWelcome_word() {
		return welcome_word;
	}
	public void setWelcome_word(String welcome_word) {
		this.welcome_word = welcome_word;
	}
	
	
	

}
