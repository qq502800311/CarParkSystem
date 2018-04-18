package org.gzhz.otherManage.bean;

import java.util.List;

import org.springframework.stereotype.Component;

/** 
* @author: 詹良斌
* @date 创建时间 2018年4月12日 下午4:00:13
* @Project: CarParkSystem
* @version V1.0 
* @parameter  *正式*针对用户表建立的用户类
* @since  
* @return
* @Description: TODO
*/
@Component
public class Parameter_Tb {
     private int parameter_id;
     private int parameter_pid;
     private String parameter_name;
     
     private List<CarportTb>  carporttblist ;
	public int getParameter_id() {
		return parameter_id;
	}
	public void setParameter_id(int parameter_id) {
		this.parameter_id = parameter_id;
	}
	public int getParameter_pid() {
		return parameter_pid;
	}
	public void setParameter_pid(int parameter_pid) {
		this.parameter_pid = parameter_pid;
	}
	public String getParameter_name() {
		return parameter_name;
	}
	public void setParameter_name(String parameter_name) {
		this.parameter_name = parameter_name;
	}
	public Parameter_Tb(int parameter_id, int parameter_pid, String parameter_name) {
		super();
		this.parameter_id = parameter_id;
		this.parameter_pid = parameter_pid;
		this.parameter_name = parameter_name;
	}
	public Parameter_Tb() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Parameter_Tb [parameter_id=" + parameter_id + ", parameter_pid=" + parameter_pid + ", parameter_name="
				+ parameter_name + "]";
	}
	public List<CarportTb> getCarporttblist() {
		return carporttblist;
	}
	public void setCarporttblist(List<CarportTb> carporttblist) {
		this.carporttblist = carporttblist;
	}

     
     
}

