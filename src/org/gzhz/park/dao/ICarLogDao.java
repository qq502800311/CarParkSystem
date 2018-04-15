package org.gzhz.park.dao;

import org.gzhz.park.bean.CarInfo;

/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年4月14日 上午10:13:10 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
public interface ICarLogDao {
	
	//停车场日志表加入记录
	public int logAddCar(CarInfo car);

}
