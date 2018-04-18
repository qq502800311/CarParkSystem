package org.gzhz.charge.dao;

import java.util.List;
import java.util.Map;

import org.gzhz.charge.bean.CarPark;
import org.gzhz.charge.bean.MoneyDetail;
import org.springframework.stereotype.Repository;

/** 
* @author  作者 E-mail: 黄彪华
* @date 创建时间：2018年4月17日 上午19:59:49 
* @version 1.03
* @parameter  
* @since  
* @return  List<CarportUserMsg>
*/

@Repository
public interface MoneyDetailMapper {
	
	//插入明收入/支出明细表
	public int addMoneyDetail(MoneyDetail detail);
	
	//查询明细（多条件查询）
	public List<MoneyDetail> findTodayMoney(Map<String,String> dateMap);
}









