package org.gzhz.park.bean;
/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年4月15日 下午3:43:35 
* @version 1.0 
* @description 车辆类型类
*/
public class CarType {
	
	private Integer parameter_id;	//车辆类型ID
	private String  parameter_name;	//车辆类型名称
	
	public CarType() {
		super();
	}

	public Integer getParameter_id() {
		return parameter_id;
	}

	public void setParameter_id(Integer parameter_id) {
		this.parameter_id = parameter_id;
	}

	public String getParameter_name() {
		return parameter_name;
	}

	public void setParameter_name(String parameter_name) {
		this.parameter_name = parameter_name;
	}
	
	

}
