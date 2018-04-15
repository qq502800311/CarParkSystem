package org.gzhz.park.bean;
/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年4月15日 下午3:56:28 
* @version 1.0 
* @description 停车场车辆查询请求参数类
*/
public class SearchPort {
	private String search_license;	//搜索目标车牌
	private String search_carType;	//搜索目标车辆类型
	private String search_date1;	//搜索目标车辆进入时间1
	private String search_date2;	//搜索目标车辆进入时间1
	private String search_area;		//搜索目标车辆停放区域
	
	public SearchPort() {
		super();
	}

	public String getSearch_license() {
		return search_license;
	}

	public void setSearch_license(String search_license) {
		this.search_license = search_license;
	}

	public String getSearch_carType() {
		return search_carType;
	}

	public void setSearch_carType(String search_carType) {
		this.search_carType = search_carType;
	}

	public String getSearch_date1() {
		return search_date1;
	}

	public void setSearch_date1(String search_date1) {
		this.search_date1 = search_date1;
	}

	public String getSearch_date2() {
		return search_date2;
	}

	public void setSearch_date2(String search_date2) {
		this.search_date2 = search_date2;
	}

	public String getSearch_area() {
		return search_area;
	}

	public void setSearch_area(String search_area) {
		this.search_area = search_area;
	}
	
	
}
