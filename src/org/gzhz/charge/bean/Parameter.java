package org.gzhz.charge.bean;

import org.springframework.stereotype.Component;

/** 
* @author  作者 E-mail: 黄彪华
* @date 创建时间：2018年4月15日 下午5:27:23
* @version 1.03
* @parameter  
* @since  
* @return  
*/

//----------参数表-----------
@Component
public class Parameter {
	private int parameter_id;
	private int parameter_pid;
	private String parameter_name;
	public Parameter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Parameter(int parameter_id, int parameter_pid, String parameter_name) {
		super();
		this.parameter_id = parameter_id;
		this.parameter_pid = parameter_pid;
		this.parameter_name = parameter_name;
	}
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
}
