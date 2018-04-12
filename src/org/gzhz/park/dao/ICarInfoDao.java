package org.gzhz.park.dao;

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
	
	public int partAddCar(CarInfo car);

}
