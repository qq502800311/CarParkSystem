package org.gzhz.otherManage.dao;

import java.util.List;

import org.gzhz.otherManage.bean.ChargeRuleTb;
import org.springframework.stereotype.Repository;

/** 
* @author: 詹良斌
* @date 创建时间 2018年4月14日 上午1:04:56
* @Project: CarParkSystem
* @version V1.0 
* @parameter  *正式*针对用户表建立的用户类
* @since  
* @return
* @Description: TODO
*/
@Repository
public interface ChargeRule1Mapper {
    //增加计费规则
	public void addChargeRule(ChargeRuleTb ruleTb)throws Exception;
	//查询计费规则
	public List<ChargeRuleTb >   findChargerulemeal();
	//修改计费规则状态（通过主键  修改启用禁用状态）
	public void   changerulestues(ChargeRuleTb ruleTb);
	//查询通过状态来查找 计费
	public List<ChargeRuleTb >   findMinitabByStatus(String status);
	//修改计费规则（通过主键 12345值）
	public void   changerulecost(ChargeRuleTb ruleTb);
	//删除计费规则（通过主键 ID来参数  ）
	public void   deletechargeRuleById(ChargeRuleTb ruleTb);
}

