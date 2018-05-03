package org.gzhz.charge.dao;

import java.util.List;

import org.gzhz.charge.bean.CarPark;
import org.springframework.stereotype.Repository;

/** 
* @author  作者 E-mail: 黄彪华
* @date 创建时间：2018年4月15日 上午10:59:49 
* @version 1.03
* @parameter  
* @since  
* @return  List<CarportUserMsg>
*/

@Repository
public interface CarParkMapper {
	
	//查找停车信息
	public CarPark searchCarParkMsg(CarPark carpark);
	
	//车辆出场--删除停车信息
	public int deleteCarParkMsg(CarPark carpark);
	
	//查找单辆车信息
	public List<CarPark> zwhFindCar(String car_park_license);
	
}