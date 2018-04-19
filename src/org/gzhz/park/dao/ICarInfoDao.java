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
	//查询当前车场车位空余情况
	public List<CarPort> searchUnusePort(Integer i);//输入车位状态ID
	//查询参数表的参数ID
	public Integer searchParameterIDByName(String str);//输入为参数的名称
	//根据车牌号查询车辆类型
	public String searchCarType(String carLicense);//输入参数为车牌号
	//根据车位类的编号将图片地址更新到数据库
	public int updateCarPortTB(CarPort carPort);
	//根据车位类的编号查询车位ID
	public CarPort searchCarPortID(CarPort carPort);
	//根据车牌号将停车位ID更新到停车场车辆数据表中
	public int updateCarParkTB(CarInfo car);

}
