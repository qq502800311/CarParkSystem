package org.gzhz.otherManage.dao;

import java.util.HashMap;
import java.util.List;

import org.gzhz.otherManage.bean.CarVipTb;
import org.gzhz.otherManage.bean.Parameter_Tb;
import org.springframework.stereotype.Repository;

/**
 * @author: 詹良斌
 * @date 创建时间 2018年4月12日 上午11:08:53
 * @Project: CarParkSystem
 * @version V1.0
 * @parameter *正式*针对用户表建立的用户类
 * @since
 * @return
 * @Description: TODO
 */
@Repository
public interface CarVipMapper {
	// 查询VIP车牌
	public List<CarVipTb> findCarVipByName(String carparklicense);

	public Parameter_Tb findvipBytype();

	// 修改车牌
	public void changevipcarbrand(HashMap<String, String> hashMap);

	// 增加车牌
	public void addvip(CarVipTb vipTb);

	// 删除车牌白名单
	public void deletevip(String currentcarparklicense);

	// 车牌号是否存在
	public CarVipTb carvipfindByName(CarVipTb carVipTb) throws Exception;

}
