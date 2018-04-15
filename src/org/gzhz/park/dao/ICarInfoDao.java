package org.gzhz.park.dao;

import java.util.List;

import org.gzhz.park.bean.CarInfo;
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
	//根据车牌或车位寻找车辆
	public List<CarInfo> searchCar();

}
