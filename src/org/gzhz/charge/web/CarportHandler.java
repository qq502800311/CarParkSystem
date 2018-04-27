package org.gzhz.charge.web;

import java.text.DecimalFormat;
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
import org.gzhz.manage.bean.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;

import dao.UserMapper;

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
	
	

	//http://localhost:8080/CarParkSystem/carport/pageToParkMsgCheck.action
	//---------跳转车位查看页面----------
	@RequestMapping("/pageToParkMsgCheck.action")
	public ModelAndView pageToParkMsgCheck(){
		System.out.println("调用查看车位信息界面");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp_hbh/check_park_msg");
		return mav;
	}
	
	//http://localhost:8080/CarParkSystem/carport/pageToTodayMoneyCheck.action
	//----------跳转今日结款账单界面---------
	@RequestMapping("/pageToTodayMoneyCheck.action")
	public ModelAndView pageToTodayMoneyCheck(){
		System.out.println("调用日结款页面");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp_hbh/today_money_checkout");
		return mav;
	}
	
	//http://localhost:8080/CarParkSystem/carport/pageToMontherUserManager.action
	//----------跳转月缴费用户充值、退款界面---------
	@RequestMapping("/pageToMontherUserManager.action")
	public ModelAndView pageToMontherUserManager(){
		System.out.println("调用月缴费用户充值、退款界面");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp_hbh/month_menber_manager");
		return mav;
	}	
	
	//http://localhost:8080/CarParkSystem/carport/pageToMontherUserRegister.action
	//----------跳转月缴费用户注册页面---------
	@RequestMapping("/pageToMontherUserRegister.action")
	public ModelAndView pageToMontherUserRegister(){
		System.out.println("调用月缴费用户注册界面");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp_hbh/month_menber_register");
		return mav;
	}		
	
	//http://localhost:8080/CarParkSystem/carport/pageToSearchMeal.action
	//----------查找套餐页面---------
	@RequestMapping("/pageToSearchMeal.action")
	public ModelAndView pageToSearchMeal(){
		System.out.println("调用套餐详情界面");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp_hbh/search_meal_msg");
		return mav;
	}		
	
	//http://localhost:8080/CarParkSystem/carport/pageToParkedCharge.action
	//----------停车收费界面、车辆放行--------
	@RequestMapping("/pageToParkedCharge.action")
	public ModelAndView pageToParkedCharge(){
		System.out.println("调用停车收费界面");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp_hbh/parking_charge");
		return mav;
	}
	
	//http://localhost:8080/CarParkSystem/carport/pageToShowDate.action
	//----------统计图表展示界面--------
	@RequestMapping("/pageToShowDate.action")
	public ModelAndView pageToShowDate(){
		System.out.println("调用显示界面图表");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp_hbh/show_date");
		return mav;
	}	
	
	//http://localhost:8080/CarParkSystem/carport/pageToChargeMeth.action
	//----------停车收费界面、车辆放行--------
	@RequestMapping("/pageToChargeMeth.action")
	public ModelAndView pageToChargeMeth(){
		System.out.println("调用缴费渠道统计页面");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp_hbh/charge_meth");
		return mav;
	}	
	
	//http://localhost:8080/CarParkSystem/carport/pageToMoneyDetail.action
	//----------明细数据--------
	@RequestMapping("/pageToMoneyDetail.action")
	public ModelAndView pageToMoneyDetail(){
		System.out.println("调用明细查询页面");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp_hbh/money_detail");
		return mav;
	}	
	
	//http://localhost:8080/CarParkSystem/carport/pageToSearchUSer.action
	//----------明细数据--------
	@RequestMapping("/pageToSearchUSer.action")
	public ModelAndView pageToSearchUSer(){
		System.out.println("用户查找页面");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp_hbh/search_user");
		return mav;
	}		
	
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
//	carport/MonthUser.action
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
		moneyDetail.setDeal_method("现金");                             //支付方式
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
	public @ResponseBody String SearchMonthUser(MonthUser user,int pageNum,int pageSize) {

		System.out.println("用户车牌:" + user.getCar_park_license());
		System.out.println("用户身份证:" + user.getUser_id());
		System.out.println(pageNum);
		System.out.println(pageSize);

		// -------------条件查询-----------
		PageHelper.startPage(pageNum, pageSize);
		List<MonthUser> users = monthdao.findConditionUser(user);
		System.out.println("返回的数据："+users);
		PageInfo<MonthUser> pageInfo = new PageInfo<MonthUser>(users);
		
		System.out.println("返回的用户列表:" + users);
		Gson gson = new Gson();
		String date = gson.toJson(pageInfo);
		System.out.println("返回的数据:"+date);
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
		moneyDetail.setDeal_method("现金");                             //支付方式
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
		moneyDetail.setDeal_method("现金");                             //支付方式
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
			// ---------------计算费用---------
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar c = Calendar.getInstance();
			String now_time = df.format(c.getTime()); // 获取系统的当前时间

			// 计算时间差
			long from = df.parse(start_time).getTime();
			long to = df.parse(now_time).getTime();
			int minutes = (int) ((to - from) / (1000 * 60));
			System.out.println("停车时间:" + minutes);

			// 获取收费规则信息
			List<ChargeRule> rules = chargeRule.findChargeRule();
			if (rules.size() != 0) {
				System.out.println("收费规则表获取成功");
			} else {
				System.out.println("收费规则表获取失败");
			}

			for (int i = 0; i < rules.size(); i++) {
				fir = rules.get(0).getCharge_rule_1();
				sec = rules.get(0).getCharge_rule_2();
				thr = rules.get(0).getCharge_rule_3();
				fur = rules.get(0).getCharge_rule_4();
				fiv = rules.get(0).getCharge_rule_5();
			}

			System.out.println("停车时间2:" + minutes);
			// 计算费用
			System.out.println("汽车类型:" + car_type);
			if (!car_type.equals("临时车辆")) {
				total_money = 0;
			} else {
				if (minutes < 30) {
					total_money = fir;
				} else if (30 <= minutes && minutes < 180) {
					int b = (int) Math.ceil((minutes - 30) / 60);
					total_money =  sec+ b * sec;

				} else if (180 <= minutes && minutes < 300) {
					int f = (int) Math.ceil((minutes - 180) / 60);
					total_money = 3 * sec + f * thr;
				}

				else if (300 <= minutes && minutes < 480) {

					int d = (int) Math.ceil((minutes - 300) / 60);
					total_money = 3 * sec + 2 * thr + fur * d;
				} else {
					int e = (int) Math.ceil((minutes - 480) / (60 * 24));
					total_money = fiv + fiv * e;
				}
			}
			String time = minutes / 60 + "小时 " + minutes % 60 + "分钟";
			carout.setCar_license(carpark.getCar_park_license());
			carout.setCar_type(car_type);
			carout.setCharge_money(String.valueOf(total_money));
			carout.setIn_time(start_time);
			carout.setOut_time(now_time);
			carout.setStop_time(time);
			System.out.println("车牌号:" + carpark.getCar_park_license());
			System.out.println("收费金额：" + total_money);
			System.out.println("出场时间：" + now_time);
			System.out.println("车辆进场时间:" + start_time);
			System.out.println("汽车类型:" + car_type);
			System.out.println("停车时间:" + time);
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
		detail.setDeal_method("现金");
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
	public @ResponseBody String searchTodayMoney(String msg,int pageNum,int pageSize) {

		System.out.println("查询的上班时间:" + msg);
		System.out.println(pageNum);
		System.out.println(pageSize);
		
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
		} else {
			start_time =now_time+" 00:00:00";
			end_time = now_time+" 24:00:00";
		}

		System.out.println("结束时间：" + end_time);
		Map<String, String> map = new HashMap<String, String>();
		map.put("start_time", start_time);
		map.put("end_time", end_time);

		// -----------查找今日所有日结款-------------
		PageHelper.startPage(pageNum, pageSize);
		
		List<MoneyDetail> details = DealDetailDao.findTodayMoney(map);
		PageInfo<MoneyDetail> pageInfo = new PageInfo<MoneyDetail>(details);
		
		if (details != null) {
			System.out.println("收费不为空");
		} else {
			System.err.println("收费为空");
		}
		Gson gson = new Gson();
		String date = gson.toJson(pageInfo);
		System.out.println(date);
		return date;
	}
	
	@RequestMapping(value = "/getProductPre.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String getFouthDateMoney(String msg) {	
		System.out.println("来自ajax的指令:" + msg);
		
		//拉取四月收费数据
		String start_time = "2018-04-01 00:00:00";
		String end_time = "2018-05-01 00:00:00";
		
		int total_cash = 0;
		int total_month = 0;
		int total_season = 0;
		int total_halfyear = 0;
		int total_money = 0;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("start_time", start_time);
		map.put("end_time", end_time);	
		List<MoneyDetail> details = DealDetailDao.findTodayMoney(map);
		System.out.println("拉回数据没:"+details);
		for(MoneyDetail m:details) {
			if(m.getDeal_matter().equals("停车收费")) {          
				total_cash += m.getDeal_money();              //临时金额
			} else if(m.getDeal_matter().equals("月套餐")) {
				total_month += m.getDeal_money();             //月套套餐金额
			} else if(m.getDeal_matter().equals("季套餐")) {
				total_season += m.getDeal_money();
			} else if(m.getDeal_matter().equals("半年套餐")) {  
				total_halfyear += m.getDeal_money();           
			}  
		}
        System.out.println("现金:"+total_cash);
        System.out.println("月套餐:"+total_month);
        System.out.println("季节占比:"+total_season);
        System.out.println("半年占比:"+total_halfyear);
        total_money = total_cash+total_month+total_season+total_halfyear;
        DecimalFormat df = new DecimalFormat("0.0");
        
        String carPer = df.format((float)total_cash/total_money*100);
        String monthPer = df.format((float)total_month/total_money*100);
        String seasonPer = df.format((float)total_season/total_money*100);
        String halfyearPer = df.format((float)total_halfyear/total_money*100);
        System.out.println("现金占比:"+carPer);
        System.out.println("月套餐占比:"+monthPer);
        System.out.println("季节占比占比:"+seasonPer);
        System.out.println("半年占比占比:"+halfyearPer);
        
        String ddd = carPer+":"+monthPer+":"+seasonPer+":"+halfyearPer;
        
		Gson gson = new Gson();
		String date = gson.toJson(ddd);
        
		return date;
	}
	
	/**
	 * @date 创建时间：2018年4月22日 上午午09:21:15
	 * @parameter
	 * @return 返回月个月收入占比
	 */
	@RequestMapping(value = "/getMonthPre.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String getMonthDateMoney(String msg) {	
		System.out.println("来自ajax的指令2:" + msg);
		
		//拉取个月收费数据
		//1月
		String start_time1 = "2018-01-01 00:00:00";
		String end_time1 = "2018-02-01 00:00:00";
		//2月
		String start_time2 = "2018-02-01 00:00:00";
		String end_time2 = "2018-03-01 00:00:00";
		//3月
		String start_time3 = "2018-03-01 00:00:00";
		String end_time3 = "2018-04-01 00:00:00";
		//4月
		String start_time4 = "2018-04-01 00:00:00";
		String end_time4 = "2018-05-01 00:00:00";
		//5月
		String start_time5 = "2018-05-01 00:00:00";
		String end_time5 = "2018-06-01 00:00:00";
		//6月
		String start_time6 = "2018-06-01 00:00:00";
		String end_time6 = "2018-07-01 00:00:00";
		//7月
		String start_time7 = "2018-07-01 00:00:00";
		String end_time7 = "2018-08-01 00:00:00";
		//8月
		String start_time8 = "2018-08-01 00:00:00";
		String end_time8 = "2018-09-01 00:00:00";
		//9月
		String start_time9 = "2018-09-01 00:00:00";
		String end_time9 = "2018-10-01 00:00:00";
		//10月
		String start_time10 = "2018-10-01 00:00:00";
		String end_time10 = "2018-11-01 00:00:00";
		//11月
		String start_time11 = "2018-11-01 00:00:00";
		String end_time11 = "2018-12-01 00:00:00";
		//12月
		String start_time12 = "2018-12-01 00:00:00";
		String end_time12 = "2019-01-01 00:00:00";

		Map<String, String> map1 = new HashMap<String, String>();
		Map<String, String> map2 = new HashMap<String, String>();
		Map<String, String> map3 = new HashMap<String, String>();
		Map<String, String> map4 = new HashMap<String, String>();
		Map<String, String> map5 = new HashMap<String, String>();
		Map<String, String> map6 = new HashMap<String, String>();
		Map<String, String> map7 = new HashMap<String, String>();
		Map<String, String> map8 = new HashMap<String, String>();
		Map<String, String> map9 = new HashMap<String, String>();
		Map<String, String> map10 = new HashMap<String, String>();
		Map<String, String> map11 = new HashMap<String, String>();
		Map<String, String> map12 = new HashMap<String, String>();
		map1.put("start_time", start_time1);
		map1.put("end_time", end_time1);
		map2.put("start_time", start_time2);
		map2.put("end_time", end_time2);
		map3.put("start_time", start_time3);
		map3.put("end_time", end_time3);
		map4.put("start_time", start_time4);
		map4.put("end_time", end_time4);
		map5.put("start_time", start_time5);
		map5.put("end_time", end_time5);
		map6.put("start_time", start_time6);
		map6.put("end_time", end_time6);
		map7.put("start_time", start_time7);
		map7.put("end_time", end_time7);
		map8.put("start_time", start_time8);
		map8.put("end_time", end_time8);
		map9.put("start_time", start_time9);
		map9.put("end_time", end_time9);
		map10.put("start_time", start_time10);
		map10.put("end_time", end_time10);
		map11.put("start_time", start_time11);
		map11.put("end_time", end_time11);
		map12.put("start_time", start_time12);
		map12.put("end_time", end_time12);
		
		int total_jan = 0;  //同于没有月收入支出
		int total_feb = 0;
		int total_mar = 0;
		int total_apr = 0;
		int total_may = 0;
		int total_jun = 0;
		int total_jul = 0;
		int total_aug = 0;
		int total_sep = 0;
		int total_oct = 0;
		int total_nov = 0;
		int total_dep = 0;
		
		int num_fou = 0;     //用与统计每个月车流量
		int num_fiv = 0;
		int num_six = 0;
		int num_sev = 0;
		int num_aug = 0;
		int num_sep = 0;
		int num_oct = 0;
		int num_nov = 0;
		int num_dep = 0;
		
		List<MoneyDetail> details = DealDetailDao.findTodayMoney(map1);
		System.out.println("获取的一月数据:"+details);	
		if(details.size()!=0) {
			for(MoneyDetail m:details) {
				total_jan += m.getDeal_money();
				
			}
		}
		
		List<MoneyDetail> detail2s = DealDetailDao.findTodayMoney(map2);
		System.out.println("获取的er月数据:"+detail2s);		
		if(detail2s.size()!=0) {
			for(MoneyDetail m:detail2s) {
				total_feb += m.getDeal_money();
			}
		}
		List<MoneyDetail> detail3s = DealDetailDao.findTodayMoney(map3);
		System.out.println("获取的san月数据:"+detail3s);
		if(detail3s.size()!=0) {
			for(MoneyDetail m:detail3s) {
				total_mar += m.getDeal_money();
			}
		}
		
		List<MoneyDetail> detail4s = DealDetailDao.findTodayMoney(map4);
		System.out.println("获取的4月数据:"+detail4s);		
		if(detail4s.size()!=0) {
			for(MoneyDetail m:detail4s) {
				total_apr += m.getDeal_money();
				if(m.getDeal_matter().equals("停车收费")) {
					num_fou++;
				}
			}
		}
		System.out.println("四月车流量:"+num_fou);
		List<MoneyDetail> detail5s = DealDetailDao.findTodayMoney(map5);
		System.out.println("获取的san月数据:"+detail5s);			
		if(detail5s.size()!=0) {
			for(MoneyDetail m:detail4s) {
				total_may += m.getDeal_money();
				if(m.getDeal_matter().equals("停车收费")) {
					num_fiv++;
				}
			}
		}
		
		List<MoneyDetail> detail6s = DealDetailDao.findTodayMoney(map6);
		System.out.println("获取的san月数据:"+detail6s);		
		if(detail6s.size()!=0) {
			for(MoneyDetail m:detail6s) {
				total_jun += m.getDeal_money();
				if(m.getDeal_matter().equals("停车收费")) {
					num_six++;
				}
			}
		}
		List<MoneyDetail> detail7s = DealDetailDao.findTodayMoney(map7);
		System.out.println("获取的7月数据:"+detail7s);		
		if(detail7s.size()!=0) {
			for(MoneyDetail m:detail7s) {
				total_jul += m.getDeal_money();
				if(m.getDeal_matter().equals("停车收费")) {
					num_sev++;
				}
			}
		}
		List<MoneyDetail> detail8s = DealDetailDao.findTodayMoney(map8);
		System.out.println("获取的8月数据:"+detail8s);		
		if(detail8s.size()!=0) {
			for(MoneyDetail m:detail8s) {
				total_aug += m.getDeal_money();
				if(m.getDeal_matter().equals("停车收费")) {
					num_aug++;
				}
			}
		}
		List<MoneyDetail> detail9s = DealDetailDao.findTodayMoney(map9);
		System.out.println("获取的san月数据:"+detail9s);		
		if(detail9s.size()!=0) {
			for(MoneyDetail m:detail9s) {
				total_sep += m.getDeal_money();
				if(m.getDeal_matter().equals("停车收费")) {
					num_sep++;
				}
			}
		}
		List<MoneyDetail> detail10s = DealDetailDao.findTodayMoney(map10);
		System.out.println("获取的10月数据:"+detail10s);		
		if(detail10s.size()!=0) {
			for(MoneyDetail m:detail10s) {
				total_oct += m.getDeal_money();
				if(m.getDeal_matter().equals("停车收费")) {
					num_oct++;
				}
			}
		}
		List<MoneyDetail> detail11s = DealDetailDao.findTodayMoney(map11);
		System.out.println("获取的san月数据:"+detail11s);		
		if(detail11s.size()!=0) {
			for(MoneyDetail m:detail11s) {
				total_nov += m.getDeal_money();
				if(m.getDeal_matter()=="停车收费") {
					num_nov++;
				}
			}
		}
		List<MoneyDetail> detail12s = DealDetailDao.findTodayMoney(map12);
		System.out.println("获取的12月数据:"+detail12s);		
		if(detail12s.size()!=0) {
			for(MoneyDetail m:detail12s) {
				total_dep += m.getDeal_money();
				if(m.getDeal_matter()=="停车收费") {
					num_dep++;
				}
			}
		}
		

        DecimalFormat df = new DecimalFormat("0.00");
        String jan = df.format((float)total_jan/10000);
        String feb = df.format((float)total_feb/10000);
        String mar = df.format((float)total_mar/10000);
        String apr = df.format((float)total_apr/10000);
        String may = df.format((float)total_may/10000);
        String jun = df.format((float)total_jun/10000);
        String jul = df.format((float)total_jul/10000);
        String aug = df.format((float)total_aug/10000);
        String sep = df.format((float)total_sep/10000);
        String oct = df.format((float)total_oct/10000);
        String nov = df.format((float)total_nov/10000);
        String dep = df.format((float)total_dep/10000);
        
		
        System.out.println("一月现金:"+jan);
        System.out.println("二月现金:"+feb);
        System.out.println("三月现金:"+mar);
        System.out.println("四月现金:"+apr);   
        System.out.println("五月现金:"+apr);     
        
        String ddd = jan+":"+feb+":"+mar+":"+apr+":"+may+":"+jun+":"+jul+":"+aug+":"+sep+":"+
        oct+":"+nov+":"+dep+":"+num_fou+":"+num_fiv+":"+num_six+":"+num_sev+":"+num_aug+":"+num_sep+
        ":"+num_oct+":"+num_nov+":"+num_dep;
		Gson gson = new Gson();
		String date = gson.toJson(ddd);
        
		return date;
	}	
	
	/**
	 * @date 创建时间：2018年4月24日 上午11:37:15
	 * @parameter
	 * @return 用于支付方式统计
	 */

	@RequestMapping(value = "/chargeMeth.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String findChargeMeth(String startDate,String stopDate,String meth,int pageNum,int pageSize) {
		
		if(startDate!="" && startDate!=null) {
			startDate = startDate+" 00:00:00";
		}else if(stopDate!="" && stopDate!=null) {
			stopDate = stopDate+" 00:00:00";
		}
		System.out.println("开始时间:" + startDate);
		System.out.println("结束时间:" + stopDate);
		System.out.println("使用方式:" + meth);
		System.out.println(pageNum);
		System.out.println(pageSize);

		// -------------条件查询-----------
		PageHelper.startPage(pageNum, pageSize);
		Map<String, String> map = new HashMap<String, String>();
		map.put("startDate", startDate);
		map.put("stopDate", stopDate);		
		map.put("meth", meth);
		
		List<MoneyDetail> details = DealDetailDao.findChargeMeth(map);
		System.out.println("返回的数据："+details);
		PageInfo<MoneyDetail> pageInfo = new PageInfo<MoneyDetail>(details);
		Gson gson = new Gson();
		String date = gson.toJson(pageInfo);
		System.out.println("返回的数据:"+date);
		return date;
	}	
}
