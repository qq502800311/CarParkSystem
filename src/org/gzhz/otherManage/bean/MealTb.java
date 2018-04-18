package org.gzhz.otherManage.bean;

import java.util.List;

import org.springframework.stereotype.Component;

/** 
* @author: 詹良斌
* @date 创建时间 2018年4月15日 下午8:47:04
* @Project: CarParkSystem23
* @version V1.0 
* @parameter  *正式*针对用户表建立的用户类
* @since  
* @return
* @Description: TODO
*/
@Component
public class MealTb {
        private int meal_id;
        private int meal_money;
        private String  meal_name;
        private String  meal_status;
        private String  meal_detail;
        private List<MealTb> list;
        private String meal_pid;
    
		
		
		public MealTb(int meal_id, int meal_money, String meal_name, String meal_status, String meal_detail,
				List<MealTb> list, String meal_pid) {
			super();
			this.meal_id = meal_id;
			this.meal_money = meal_money;
			this.meal_name = meal_name;
			this.meal_status = meal_status;
			this.meal_detail = meal_detail;
			this.list = list;
			this.meal_pid = meal_pid;
		}
		public String getMeal_pid() {
			return meal_pid;
		}
		public void setMeal_pid(String meal_pid) {
			this.meal_pid = meal_pid;
		}
		public MealTb() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getMeal_id() {
			return meal_id;
		}
		public void setMeal_id(int meal_id) {
			this.meal_id = meal_id;
		}
		public int getMeal_money() {
			return meal_money;
		}
		public void setMeal_money(int meal_money) {
			this.meal_money = meal_money;
		}
		public String getMeal_name() {
			return meal_name;
		}
		public void setMeal_name(String meal_name) {
			this.meal_name = meal_name;
		}
		public String getMeal_status() {
			return meal_status;
		}
		public void setMeal_status(String meal_status) {
			this.meal_status = meal_status;
		}
		public String getMeal_detail() {
			return meal_detail;
		}
		public void setMeal_detail(String meal_detail) {
			this.meal_detail = meal_detail;
		}
		@Override
		public String toString() {
			return "MealTb [meal_id=" + meal_id + ", meal_money=" + meal_money + ", meal_name=" + meal_name
					+ ", meal_status=" + meal_status + ", meal_detail=" + meal_detail + ", list=" + list + ", meal_pid="
					+ meal_pid + "]";
		}
		public List<MealTb> getList() {
			return list;
		}
		public void setList(List<MealTb> list) {
			this.list = list;
		}
        
}

