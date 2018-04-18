package org.gzhz.otherManage.dao;

import java.util.HashMap;
import java.util.List;

import org.gzhz.otherManage.bean.ChargeRuleTb;
import org.gzhz.otherManage.bean.MealTb;
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
public interface PayMonthMapper {
	// 查询计费规则
	public List<MealTb> findpaymonth();

	// //增加计费规则
	public int insertWithList(List<MealTb> list) throws Exception;

	// 统计这张表多少个值 返回int值
	public int selectcountmealtb();

	// //修改计费规则状态（通过主键 修改套餐值）
	public void updatemoney(HashMap<String, String> hashMap);

	// 修改计费规则（通过Pid修改状态 ）
	public void updatestatus(HashMap<String, String> hashMap);
	
	// 查找状态 返回一个集合
	public List<MealTb> selectstatus(String staues);

	// 删除计费规则（通过主键 ID来参数 ）
	public void deletemealtbById(String pid);
}
