package org.gzhz.charge.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.gzhz.charge.bean.CarLog;
import org.gzhz.charge.bean.CarOutMsg;
import org.gzhz.charge.bean.CarPark;
import org.gzhz.charge.bean.CarportUserMsg;
import org.gzhz.charge.bean.ChargeRule;
import org.gzhz.charge.bean.Meal;
import org.gzhz.charge.bean.MoneyDetail;
import org.gzhz.charge.bean.MonthUser;
import org.gzhz.charge.dao.CarLogMapper;
import org.gzhz.charge.dao.CarParkMapper;
import org.gzhz.charge.dao.CarportUserMsgMapper;
import org.gzhz.charge.dao.ChargeRuleMapper;
import org.gzhz.charge.dao.MealMapper;
import org.gzhz.charge.dao.MoneyDetailMapper;
import org.gzhz.charge.dao.MonthUserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;

/**
 * @author 作者 E-mail: 黄彪华
 * @date 创建时间：2018年4月12日 上午11:28:13
 * @version 1.03
 * @parameter
 * @since
 * @return
 */

@Controller
@RequestMapping("/carport")
public class CarportHandler {

	@Resource
	private CarportUserMsgMapper carport_msg;
	@Resource
	private MealMapper meal_mapper;
	@Resource
	private MonthUserMapper monthdao;
	@Resource
	private CarParkMapper carParkDao;
	@Resource
	private CarLogMapper carlog;
	@Resource
	private MoneyDetailMapper DealDetailDao;
	@Resource
	private ChargeRuleMapper chargeRule;
	/**
	 * @date 创建时间：2018年4月12日 下午14:28:13
	 * @parameter
	 * @since
	 * @return 返回车位信息对象，传到ajax显示在界面
	 */
	@RequestMapping(value = "/checkParkMsg.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody CarportUserMsg findCarportMsg(String check_msg) {
		System.out.println("收到ajax的数据:" + check_msg);

		List<CarportUserMsg> carport_msg_list = carport_msg.findAllMsg();
		System.out.println("获取的车位信息列表:" + carport_msg_list);
		CarportUserMsg carport = carport_msg_list.get(0);

		System.out.println("剩余车位数:" + carport.getCarport_remain_num());
		System.out.println("使用中车位数:" + carport.getCarport_using_num());

		return carport;
	}

	/**
	 * @date 创建时间：2018年4月12日 下午16:21:15
	 * @parameter
	 * @return 返回套餐信息列表，显示在界面表格
	 */
	@RequestMapping(value = "/searchMealMsg.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String findMealMsg(String meal_msg) {
		System.out.println("收到ajax的数据:" + meal_msg);

		List<Meal> meals = meal_mapper.findAllMeal();
		System.out.println("获取的套餐列表:" + meals);
		Gson gson = new Gson();
		String date = gson.toJson(meals);
		System.out.println(meals);
		return date;
	}

	/**
	 * @date 创建时间：2018年4月13日 下午15:37:15
	 * @parameter
	 * @return 月缴费用户办理套餐，返回数字，1，插入成功
	 */

	@RequestMapping(value = "/MonthUser.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody MonthUser addMonthUser(@RequestBody MonthUser user) {

		// -------------插入套餐开始时间和结束时间--------------
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar c = Calendar.getInstance();
		Calendar b = Calendar.getInstance();
		Calendar a = Calendar.getInstance();
		String now_time = df.format(c.getTime()); // 获取系统的当前时间
		System.out.println("单前时间：" + now_time);

		c.add(Calendar.MONTH, 1);
		String month_later = df.format(c.getTime()); // 一个月后时间
		System.out.println("一个月后时间：" + month_later);

		b.add(Calendar.MONTH, 3);
		String three_month = df.format(b.getTime()); // 三个月后时间
		System.out.println("三个月后时间：" + three_month);

		a.add(Calendar.MONTH, 6);
		String half_year = df.format(a.getTime()); // 半年后时间
		System.out.println("半年后时间：" + half_year);

		// --------根据选择的套餐，设置套餐终止的日期-------
		int meal_id = user.getMeal_id();
		if (meal_id == 1) {
			user.setUser_timeout_date(month_later);
		} else if (meal_id == 2) {
			user.setUser_timeout_date(three_month);
		} else if (meal_id == 3) {
			user.setUser_timeout_date(half_year);
		}

		System.out.println("月缴费用户姓名:" + user.getUser_name());
		System.out.println("用户选择的套餐:" + user.getMeal_id());
		System.out.println("用户车牌:" + user.getCar_park_license());

		user.setUser_status("启用");
		user.setUser_register_date(now_time);
		
		//--------------数据插入明细表-----------
		String meal_name = null;   
		int meal_money= 0;
		List<Meal> meals = meal_mapper.findAllMeal();
		for(Meal m:meals) {
			if(user.getMeal_id()==m.getMeal_id()) {
				meal_name=m.getMeal_name();
				meal_money = m.getMeal_money();
			}
		}
		MoneyDetail moneyDetail = new MoneyDetail();
		moneyDetail.setCar_park_license(user.getCar_park_license());   //用户车牌
		moneyDetail.setDeal_matter(meal_name);                         //操作事项（套餐名）
		moneyDetail.setDeal_method("待定");                             //支付方式
		moneyDetail.setDeal_money(meal_money);                         //支付金额
		moneyDetail.setDeal_time(now_time);                            //支付时间
		int t = DealDetailDao.addMoneyDetail(moneyDetail);
		if(t>0) {
			System.out.println("明细表添加成功");
		}else {
			System.out.println("明细表添加失败");
		}
		
		// -------------数据插入月缴费用户表-----------
		int back = monthdao.addMonthUser(user);
		if (back > 0) {
			System.out.println("月缴费办理成功");

		} else {
			System.out.println("月缴费办理失败");
		}
		return user;
	}

	/**
	 * @date 创建时间：2018年4月13日 下午23:21:15
	 * @parameter
	 * @return 数据库判断用户id是否唯一
	 */
	@RequestMapping(value = "/checkUserId.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String CheckUserId(String user_id) {
		System.out.println("收到ajax用户id:" + user_id);
		String msg = null;
		List<MonthUser> users = monthdao.findAllMonthUser();
		ArrayList<String> userids = new ArrayList<String>();

		for (MonthUser mu : users) {
			userids.add(mu.getUser_id());
		}
		if (userids.contains(user_id)) {
			msg = "用户id已使用";
		} else {
			msg = "通过";
		}
		Gson gson = new Gson();
		String date = gson.toJson(msg);
		return date;
	}

	/**
	 * @date 创建时间：2018年4月14日 上午09:21:15
	 * @parameter
	 * @return 数据库判断月缴费用户车牌是否唯一
	 */
	@RequestMapping(value = "/checkLicense.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String CheckLicense(String license) {
		System.out.println("收到ajax用户id:" + license);
		String msg = null;
		List<MonthUser> users = monthdao.findAllMonthUser();
		ArrayList<String> licenses = new ArrayList<String>();

		for (MonthUser mu : users) {
			licenses.add(mu.getCar_park_license());
		}
		if (licenses.contains(license)) {
			msg = "用户车牌已使用";
		} else {
			msg = "通过";
		}
		Gson gson = new Gson();
		String date = gson.toJson(msg);
		return date;
	}

	/**
	 * @date 创建时间：2018年4月14日 上午11:37:15
	 * @parameter
	 * @return 用户套餐信息查询，用于账号管理、退款
	 */

	@RequestMapping(value = "/searchUser.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String SearchMonthUser(@RequestBody MonthUser user) {

		System.out.println("用户车牌:" + user.getCar_park_license());
		System.out.println("用户身份证:" + user.getUser_id());

		// -------------条件查询-----------
		List<MonthUser> users = monthdao.findConditionUser(user);
		System.out.println("返回的用户列表:" + users);
		Gson gson = new Gson();
		String date = gson.toJson(users);
		return date;
	}

	/**
	 * @date 创建时间：2018年4月15日 下午14:28:13
	 * @parameter
	 * @since
	 * @return 退款处理，返回字符串，显示在界面
	 */
	@RequestMapping(value = "/returnMoney.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String returnMoney(@RequestBody MonthUser user) {
		System.out.println("退款用户id:" + user.getUser_id());
		System.out.println("退款用户车牌:" + user.getCar_park_license());
		System.out.println("退款用户金额:" + user.getMeal_id());
		user.setUser_status("已退款");
		String msg = null;
		
		//--------------数据插入明细表-----------
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		String now_time = df.format(c.getTime()); // 获取系统的当前时间		

		MoneyDetail moneyDetail = new MoneyDetail();
		moneyDetail.setCar_park_license(user.getCar_park_license());   //用户车牌
		moneyDetail.setDeal_matter("退款");                         //操作事项（套餐名）
		moneyDetail.setDeal_method("待定");                             //支付方式
		moneyDetail.setDeal_money(-user.getMeal_id());                  //支付金额
		moneyDetail.setDeal_time(now_time);                            //支付时间
		int t = DealDetailDao.addMoneyDetail(moneyDetail);
		if(t>0) {
			System.out.println("明细表添加成功");
		}else {
			System.out.println("明细表添加失败");
		}		
		
		//-------------月缴费用户表状态更改-------------
		int back = monthdao.updateMonthUser(user);
		if (back > 0) {
			msg = "退款成功！";
			System.out.println(msg);
		} else {
			msg = "退款失败！";
			System.out.println(msg);
		}
		Gson gson = new Gson();
		String date = gson.toJson(msg);
		return date;
	}

	/**
	 * @date 创建时间：2018年4月15日 下午18:28:13
	 * @parameter
	 * @since
	 * @return 办理过月缴费用户重新充值
	 */
	@RequestMapping(value = "/rehchargeMoney.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String rechargeMoney(@RequestBody MonthUser user) {
		System.out.println("用户车牌:" + user.getCar_park_license());
		System.out.println("用户办理的套餐:" + user.getMeal_id());

		// -------------插入套餐开始时间和结束时间--------------
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar c = Calendar.getInstance();
		Calendar b = Calendar.getInstance();
		Calendar a = Calendar.getInstance();
		String now_time = df.format(c.getTime()); // 获取系统的当前时间
		System.out.println("单前时间：" + now_time);

		c.add(Calendar.MONTH, 1);
		String month_later = df.format(c.getTime()); // 一个月后时间
		System.out.println("一个月后时间：" + month_later);

		b.add(Calendar.MONTH, 3);
		String three_month = df.format(b.getTime()); // 三个月后时间
		System.out.println("三个月后时间：" + three_month);

		a.add(Calendar.MONTH, 6);
		String half_year = df.format(a.getTime()); // 半年后时间
		System.out.println("半年后时间：" + half_year);

		// --------根据选择的套餐，设置套餐终止的日期-------
		int meal_id = user.getMeal_id();
		if (meal_id == 1) {
			user.setUser_timeout_date(month_later);
		} else if (meal_id == 2) {
			user.setUser_timeout_date(three_month);
		} else if (meal_id == 3) {
			user.setUser_timeout_date(half_year);
		}

		user.setUser_status("启用");
		user.setUser_register_date(now_time);
		
		//---------明细表插入数据--------------
		String meal_name = null;   
		int meal_money= 0;
		List<Meal> meals = meal_mapper.findAllMeal();
		for(Meal m:meals) {
			if(user.getMeal_id()==m.getMeal_id()) {
				meal_name=m.getMeal_name();
				meal_money = m.getMeal_money();
			}
		}
		MoneyDetail moneyDetail = new MoneyDetail();
		moneyDetail.setCar_park_license(user.getCar_park_license());   //用户车牌
		moneyDetail.setDeal_matter(meal_name);                         //操作事项（套餐名）
		moneyDetail.setDeal_method("待定");                             //支付方式
		moneyDetail.setDeal_money(meal_money);                         //支付金额
		moneyDetail.setDeal_time(now_time);                            //支付时间
		int t = DealDetailDao.addMoneyDetail(moneyDetail);
		if(t>0) {
			System.out.println("明细表添加成功");
		}else {
			System.out.println("明细表添加失败");
		}		
		
		
		// --------月缴费用户更新数据----------
		String msg = null;
		int back = monthdao.rechargeUpdate(user);
		if (back > 0) {
			msg = "充值成功！";
			System.out.println(msg);
		} else {
			msg = "充值失败！";
			System.out.println(msg);
		}
		Gson gson = new Gson();
		String date = gson.toJson(msg);
		return date;
	}

	/**
	 * @date 创建时间：2018年4月15日 下午19:28:13
	 * @parameter
	 * @since
	 * @return 停车收费，查找停车信息,计算停车费用
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/searchParking.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody CarOutMsg searchParking(@RequestBody CarPark carpark) throws ParseException {
		System.out.println("即将出场的车辆车牌:" + carpark.getCar_park_license());
		CarOutMsg carout = new CarOutMsg();
		int total_money = 0;
		int fir = 0;
		int sec = 0;
		int thr = 0;
		int fur = 0;
		int fiv = 0;		
		// ---------数据库获取当前车辆停车信息---------
		CarPark car = carParkDao.searchCarParkMsg(carpark);

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
			carout.setCar_license(carpark.getCar_park_license());
			carout.setCar_type(car_type);
			carout.setCharge_money(String.valueOf(total_money));
			carout.setIn_time(start_time);
			carout.setOut_time(now_time);
			carout.setStop_time(time);
			System.out.println("车牌号:"+carpark.getCar_park_license());
			System.out.println("收费金额："+total_money);
			System.out.println("出场时间："+now_time);
			System.out.println("车辆进场时间:"+start_time);
			System.out.println("汽车类型:" +car_type);
			System.out.println("停车时间:"+time);
		}
		return carout;
	}

	/**
	 * @date 创建时间：2018年4月16日 上午10:02:13
	 * @parameter
	 * @since
	 * @return 停车收费，查找停车信息,计算停车费用
	 */
	@RequestMapping(value = "/deleteOutCarMsg.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String deleteParkedMsg(@RequestBody MoneyDetail detail) {
		System.out.println("要删除车辆车牌:" + detail.getCar_park_license());
		System.out.println("收费金额:" + detail.getDeal_money());
		System.out.println("收费时间:" + detail.getDeal_time());
		String str = null;
		Gson gson = new Gson();
		//----------收费信息插入明细表--------
		detail.setDeal_matter("停车收费");
		detail.setDeal_method("待定");
		int t = DealDetailDao.addMoneyDetail(detail);
		if(t>0) {
			System.out.println("明细表添加成功");
		}else {
			System.out.println("明细表添加失败");
		}
		// ---------数据库删除当前车辆停车信息---------
		 CarPark carpark = new CarPark();
		 carpark.setCar_park_license(detail.getCar_park_license());
		int back = carParkDao.deleteCarParkMsg(carpark);
		if (back > 0) {
			str = "放行成功!";
		} else {
			str = "放行失败！";
		}
		String date = gson.toJson(str);
		return date;
	}

	/**
	 * @date 创建时间：2018年4月13日 下午23:21:15
	 * @parameter
	 * @return     日结款明细查询
	 */
	@RequestMapping(value = "/searchMoney.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String searchTodayMoney(String msg) {

		System.out.println("查询的上班时间:" + msg);
		String work_time = msg;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		String now_time = df.format(c.getTime()); // 获取系统的当前时间

		String start_time = null; // 上班开始时间
		String end_time = null; // 上班结束时间
		System.out.println("系统当前时间：" + now_time);
		if (work_time.equals("早班")) {
			start_time = now_time + " 08:00:00";
			end_time = now_time + " 16:00:00";

		} else if (work_time.equals("中班")) {
			start_time = now_time + " 16:00:00";
			end_time = now_time + " 24:00:00";
		} else if (work_time.equals("晚班")) {
			start_time = now_time + " 00:00:00";
			end_time = now_time + " 08:00:00";
		}
		
		System.out.println("结束时间：" + end_time);
		Map<String, String> map = new HashMap<String, String>();
		map.put("start_time", start_time);
		map.put("end_time", end_time);

		//-----------查找今日所有日结款-------------
		List<MoneyDetail> details = DealDetailDao.findTodayMoney(map);
		if(details!=null) {
			System.out.println("收费不为空");
		}else {
			System.err.println("收费为空");
		}
		Gson gson = new Gson();
		String date = gson.toJson(details);
		System.out.println(date);
		return date;
	}
}
