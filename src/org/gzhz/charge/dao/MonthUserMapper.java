package org.gzhz.charge.dao;

import java.util.List;
import java.util.Map;

import org.gzhz.charge.bean.MonthUser;
import org.springframework.stereotype.Repository;

/** 
* @author  作者 E-mail: 黄彪华
* @date 创建时间：2018年4月12日 上午10:59:49 
* @version 1.03
* @parameter  
* @since  
* @return  List<CarportUserMsg>
*/

@Repository
public interface MonthUserMapper {
	
	//添加月缴费用户
	public int addMonthUser(MonthUser user);
	
	//查找所有的月缴费用户
	public List<MonthUser> findAllMonthUser();
	
	//条件查找月缴费用户
	public List<MonthUser> findConditionUser(MonthUser user);
	
	//更新用户信息（状态）
	public int updateMonthUser(MonthUser user);
	
	//用户充值更新
	public int rechargeUpdate(MonthUser user);
	
	//查找今日的月缴费总金额
	public List<MonthUser> getTodayMoney(Map<String,String> dateMap);
}









