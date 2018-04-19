package org.gzhz.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.gzhz.charge.bean.CarOutMsg;
import org.gzhz.charge.bean.CarPark;
import org.gzhz.charge.bean.ChargeRule;
import org.gzhz.charge.dao.CarParkMapper;
import org.gzhz.charge.dao.ChargeRuleMapper;
import org.gzhz.park.bean.CarInfo;
import org.springframework.stereotype.Component;

/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年4月16日 上午9:54:00 
* @version 1.0 
* @description 用于处理所有停车场收费业务
*/
@Component
public class CarChargeUnitl {
	@Resource
	private CarParkMapper carParkDao;
	@Resource
	private ChargeRuleMapper chargeRule;
	
	public CarOutMsg chargeCarOut(CarPark carPark) throws ParseException{
		System.out.println("即将出场的车辆车牌:" + carPark.getCar_park_license());
		CarOutMsg carout = new CarOutMsg();
		int total_money = 0;
		int fir = 0;
		int sec = 0;
		int thr = 0;
		int fur = 0;
		int fiv = 0;		
		// ---------数据库获取当前车辆停车信息---------
		CarPark car = carParkDao.searchCarParkMsg(carPark);

		if (car == null) {
			String str = "用户不存在！";
		} else {
			String car_type = car.getParameter().getParameter_name();
			String start_time = car.getCar_in_time();
			//---------------计算费用---------
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar c = Calendar.getInstance();
			String now_time = df.format(c.getTime()); // 获取系统的当前时间

			//计算时间差
			long from = df.parse(start_time).getTime();
			long to = df.parse(now_time).getTime();  
			int minutes = (int) ((to - from)/(1000 * 60)); 
			System.out.println("停车时间:"+minutes);
			
			//获取收费规则信息
			List<ChargeRule> rules = chargeRule.findChargeRule();
			if(rules.size()!=0) {
				System.out.println("收费规则表获取成功");
			}else {
				System.out.println("收费规则表获取失败");
			}

			for (int i = 0; i < rules.size(); i++) {
				fir = rules.get(0).getCharge_rule_1();
				sec = rules.get(0).getCharge_rule_2();
				thr = rules.get(0).getCharge_rule_3();
				fur = rules.get(0).getCharge_rule_4();
				fiv = rules.get(0).getCharge_rule_5();
			}
			
			System.out.println("停车时间2:"+minutes);
			//计算费用
			System.out.println("汽车类型:" +car_type);
			if(!car_type.equals("临时车辆")) {
				total_money = 0;
			}else {
				if(minutes<30) {
					int a = fir;
					total_money = a*sec;
				}else if(30<=minutes && minutes<180){
					int b = (int) Math.ceil((minutes-30)/60);
					total_money = 3*sec+b*thr;		
					
				}else if(180<=minutes && minutes<300) {
					int b = (int) Math.ceil((minutes-180)/60);
					total_money = 3*sec+b*thr;
				}
				
				else if(300<=minutes && minutes<480){
					
					int d = (int) Math.ceil((minutes-300)/60);	
					total_money = 3*sec+2*thr+fur*d;
				}else {
					int e = (int) Math.ceil((minutes-480)/(60*24));
					total_money = 3*sec+2*thr+fur*3+fiv*e;					
				}
			}
			String time = minutes/60+"小时 "+minutes%60+"分钟";
			carout.setCar_license(carPark.getCar_park_license());
			carout.setCar_type(car_type);
			carout.setCharge_money(String.valueOf(total_money));
			carout.setIn_time(start_time);
			carout.setOut_time(now_time);
			carout.setStop_time(time);
			System.out.println("车牌号:"+carPark.getCar_park_license());
			System.out.println("收费金额："+total_money);
			System.out.println("出场时间："+now_time);
			System.out.println("车辆进场时间:"+start_time);
			System.out.println("汽车类型:" +car_type);
			System.out.println("停车时间:"+time);
		}
		return carout;
	}
}
