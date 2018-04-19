/**
 * 
 */
package org.gzhz.manage.bean;

import org.springframework.stereotype.Component;

/** 
* @author  作者 E-mail: 郑伟豪
* @date 创建时间：2018年4月16日 上午8:21:09 
* @version 1.0 
* @parameter  参数类
* @since  
* @return  
*/
@Component("Parameter1")
public class Parameter {
	private int parameter_id;
	private int parameter_pid;
	private String parameter_name;
	
	private String second_parameter_name;
	
	public Parameter() {
		super();
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

	public String getSecond_parameter_name() {
		return second_parameter_name;
	}

	public void setSecond_parameter_name(String second_parameter_name) {
		this.second_parameter_name = second_parameter_name;
	}
	
	
}
