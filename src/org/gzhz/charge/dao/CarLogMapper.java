package org.gzhz.charge.dao;

import java.util.List;
import java.util.Map;

import org.gzhz.charge.bean.CarLog;
import org.springframework.stereotype.Repository;

/** 
* @author  作者 E-mail: 黄彪华
* @date 创建时间：2018年4月17日 上午10:59:49 
* @version 1.03
* @parameter  
* @since  
* @return  
*/

@Repository
public interface CarLogMapper {
	
	//收费信息查询，用于收费日结单
	public List<CarLog> findTodayMoney(Map<String,String> dateMap);

}









