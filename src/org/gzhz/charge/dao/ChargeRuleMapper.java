package org.gzhz.charge.dao;

import java.util.List;

import org.gzhz.charge.bean.ChargeRule;
import org.springframework.stereotype.Repository;

/** 
* @author  作者 E-mail: 黄彪华
* @date 创建时间：2018年4月18日 上午10:59:49 
* @version 1.03
* @parameter  
* @since  
* @return  
*/

@Repository
public interface ChargeRuleMapper {
	
	//查找计费规则表，数据用于计算停车收费
	public List<ChargeRule> findChargeRule();

}




