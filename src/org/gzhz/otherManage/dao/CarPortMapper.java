package org.gzhz.otherManage.dao;

import java.util.HashMap;
import java.util.List;

import org.gzhz.otherManage.bean.CarportTb;
import org.gzhz.otherManage.bean.ChargeRuleTb;
import org.gzhz.otherManage.bean.MealTb;
import org.gzhz.otherManage.bean.Parameter_Tb;
import org.springframework.stereotype.Repository;

/**
 * @author: 詹良斌
 * @date 创建时间 2018年4月17日 15:00:16
 * @Project: CarParkSystem
 * @version V1.0
 * @parameter *正式*针对用户表建立的用户类
 * @since
 * @return
 * @Description: TODO
 */
@Repository
public interface CarPortMapper {
	// 查询计费规则
//	public List<MealTb> findpaymonth();
	
	public List<CarportTb> findCarportByName(HashMap<String , String> hashMap);
    
	public Parameter_Tb findidBystatus(int status);
//	// //增加计费规则
	public int insertcarport(List<CarportTb> list) throws Exception;
//
//	// 统计这张表多少个值 返回int值
//	public int selectcountmealtb();
//
//	// //修改计费规则状态（通过主键 修改套餐值）
//	public void updatemoney(HashMap<String, String> hashMap);
//
//	// 修改计费规则（通过Pid修改状态 ）
	public void updatcarportstatus(CarportTb carportTb);
//	
//	// 查找状态 返回一个集合
//	public List<MealTb> selectstatus(String staues);
//
//	// 删除计费规则（通过主键 ID来参数 ）
//	public void deletemealtbById(String pid);
}
