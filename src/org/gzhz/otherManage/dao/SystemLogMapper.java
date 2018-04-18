package org.gzhz.otherManage.dao;

import java.util.HashMap;
import java.util.List;

import org.gzhz.otherManage.bean.ChargeRuleTb;
import org.gzhz.otherManage.bean.LogTb;
import org.gzhz.otherManage.bean.MealTb;
import org.gzhz.otherManage.bean.MoneyDetailTb;
import org.springframework.stereotype.Repository;

/**
 * @author: 詹良斌
 * @date 创建时间 2018年4月14日 上午1:04:56
 * @Project: CarParkSystem
 * @version V1.0
 * @parameter *正式*针对用户表建立的用户类
 * @since
 * @return
 * @Description: TODO
 */
@Repository
public interface SystemLogMapper {
	//查找时间 统计  endtime_moneydetail starttime_moneydetail  两参数
	public List<LogTb> selectlog(HashMap< String , String> hashMap);
}
