package org.gzhz.park.dao;

import java.util.List;
import java.util.Map;

import org.gzhz.park.bean.CarInfo;
import org.gzhz.park.bean.CarPort;
import org.gzhz.park.bean.SearchPort;
import org.springframework.stereotype.Repository;

/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年4月12日 上午10:47:13 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
@Repository
public interface ICarInfoDao {
	//停车场数据表加入车辆
	public int partAddCar(CarInfo car);
	//停车场数据表删除车辆
	public int partDeleteCar(CarInfo car);
	//根据条件查询车场车辆
	public List<CarInfo> searchCar(SearchPort sp);
	//根据条件查询车位情况
	public List<CarPort> searchAllCarPort(Map<String,String> map);

}
